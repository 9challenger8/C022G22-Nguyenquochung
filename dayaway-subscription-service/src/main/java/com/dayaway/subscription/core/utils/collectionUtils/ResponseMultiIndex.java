package com.dayaway.subscription.core.utils.collectionUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMultiIndex
{
    private Integer fromIndex;

    private Integer toIndex;

    public ResponseMultiIndex()
    {
        super();
    }

    public ResponseMultiIndex(Integer fromIndex, Integer toIndex)
    {
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
    }
}
