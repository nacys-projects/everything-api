package org.nacys_projects.number_theory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrimeGeneratorTests {
    PrimeGenerator primeGenerator = new PrimeGenerator();

    @ParameterizedTest
    @MethodSource("primeTestData")
    void primesLessThanOrEqualTo_shouldReturnPrimesLessThanOrEqualToBound(int upperBound, List<Integer> expectedPrimes) {
        assertThat(primeGenerator.primesLessThanOrEqualTo(upperBound)).isEqualTo(expectedPrimes);
    }

    static List<Arguments> primeTestData() {
        return List.of(
                Arguments.of(2, List.of(2)),
                Arguments.of(5, List.of(2, 3, 5)),
                Arguments.of(6, List.of(2, 3, 5)),
                Arguments.of(7, List.of(2, 3, 5, 7)),
                Arguments.of(8, List.of(2, 3, 5, 7)),
                Arguments.of(9, List.of(2, 3, 5, 7)),
                Arguments.of(11, List.of(2, 3, 5, 7, 11)),
                Arguments.of(25, List.of(2, 3, 5, 7, 11, 13, 17, 19, 23))
        );
    }

    @Test
    void primesLessThanOrEqualTo_shouldReturnEmptyListWhenBoundIsLessThanOrEqualToOne() {
        List<Integer> primes = primeGenerator.primesLessThanOrEqualTo(-1);
        assertThat(primes).isEmpty();

        primes = primeGenerator.primesLessThanOrEqualTo(0);
        assertThat(primes).isEmpty();

        primes = primeGenerator.primesLessThanOrEqualTo(1);
        assertThat(primes).isEmpty();
    }
}
