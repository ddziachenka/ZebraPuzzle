package io.xdatagroup.puzzle

object HeapsPermutation {

    fun permute(vararg input: Int): Set<IntArray> {
        val result = mutableSetOf<IntArray>()
        generate(input.size, input, result)
        return result
    }

    private fun generate(k: Int, input: IntArray, result: MutableSet<IntArray>) {
        if (k == 1) {
            result.add(input.copyOf())
        } else {
            for (i in 0 until k) {
                generate(k - 1, input, result)
                if (isEven(k)) {
                    swap(input, i, k - 1)
                } else {
                    swap(input, 0, k - 1)
                }
            }
        }
    }

    private fun isEven(i: Int) = i and 1 == 0

    private fun swap(input: IntArray, a: Int, b: Int) {
        if (a != b) {
            val temp = input[a]
            input[a] = input[b]
            input[b] = temp
        }
    }
}