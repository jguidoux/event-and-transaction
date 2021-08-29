package com.example.eventandtransactions.nonnull

import org.junit.jupiter.api.Test

class RandomMethodTest {

    @Test
    fun `ne devrait pas pouvoir passer null en argutment`() {

        RandomMethod().methodWithNotNullArgument(null)

    }
}