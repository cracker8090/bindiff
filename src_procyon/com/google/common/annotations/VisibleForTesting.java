package com.google.common.annotations;

import java.lang.annotation.*;

@GwtCompatible
public @interface VisibleForTesting {
    @GoogleInternal
    VisibleForTesting$Visibility productionVisibility() default VisibleForTesting$Visibility.PRIVATE;
}
