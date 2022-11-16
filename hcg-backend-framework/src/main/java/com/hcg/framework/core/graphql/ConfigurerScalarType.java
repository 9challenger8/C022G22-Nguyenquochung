package com.hcg.framework.core.graphql;

import com.hcg.framework.dto.post.PostDto;
import graphql.scalars.ExtendedScalars;
import graphql.scalars.datetime.DateTimeScalar;
import graphql.schema.idl.TypeRuntimeWiring;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.graphql.execution.ClassNameTypeResolver;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
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
