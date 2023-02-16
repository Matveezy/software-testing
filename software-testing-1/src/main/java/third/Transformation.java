package third;

import java.util.Optional;

public interface Transformation<F, T> {

    Optional<T> transform(F from);
}
