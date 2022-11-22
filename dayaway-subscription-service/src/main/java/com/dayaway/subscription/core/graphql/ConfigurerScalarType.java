package com.dayaway.subscription.core.graphql;

import graphql.scalars.ExtendedScalars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Configuration
public class ConfigurerScalarType {


    @Bean
    RuntimeWiringConfigurer configurer() {

        return (builder) -> builder

                .scalar(ExtendedScalars.Date)
                .scalar(ExtendedScalars.DateTime)
                .scalar(ExtendedScalars.UUID)
                .scalar(ExtendedScalars.GraphQLBigInteger)
                .scalar(ExtendedScalars.GraphQLBigDecimal)
                .type("ResponseModel",
                        typeBuilder -> {
                            typeBuilder.typeResolver(typeResolutionEnvironment -> {
                                Class cl = typeResolutionEnvironment.getObject().getClass();
                                Optional<String> name = findFromSchemaTypeAnnotation(cl)
                                        .or(() -> findByMatchingClassName(cl, typeResolutionEnvironment.getSchema()::containsType));

                                return typeResolutionEnvironment.getSchema().getObjectType(
                                        name.orElseThrow(() -> createCannotResoleSchemaTypeException(cl)));
                            });
                            return typeBuilder;
                        });
    }

    private RuntimeException createCannotResoleSchemaTypeException(Class cl) {
        return new RuntimeException("Cannot resolve " + cl.getName() + " within grapqhl schema");
    }

    private Optional<String> findByMatchingClassName(Class cl, Predicate<String> containsType) {
        return Stream.iterate(cl, Objects::nonNull, c -> c.getSuperclass())
                .map(Class::getSimpleName)
                .filter(containsType)
                .findFirst();
    }

    private Optional<String> findFromSchemaTypeAnnotation(Class cl) {
        return Stream.iterate(cl, Objects::nonNull, c -> c.getSuperclass())
                .filter(c -> c.isAnnotationPresent(SchemaType.class))
                .findFirst()
                .map(c -> (SchemaType) c.getAnnotation(SchemaType.class))
                .map(SchemaType::value);
    }


}
