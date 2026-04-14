package com.thealgorithms.sorts;

/**
 * バブルソート（Bubble Sort）を実装したクラスです。
 *
 * バブルソートは、配列の隣り合う要素を順番に比較し、必要に応じて入れ替える操作を繰り返すことで、配列全体を昇順に並べ替える最も基本的なソートアルゴリズムの一つです。
 *
 * 例：
 * [5, 3, 8, 2] の場合、
 * 1回目のループで [3, 5, 2, 8] → [3, 2, 5, 8] → [2, 3, 5, 8] のように、
 * 大きい値が右側に「泡（バブル）」のように移動していきます。
 *
 * 配列がすでに整列済みの場合はすぐに終了します。
 *
 * 計算量：
 * - 最良：O(n)（すでに整列済み）
 * - 平均・最悪：O(n^2)
 *
 * 空間計算量：O(1)（追加の配列を使わず、その場で並べ替えます）
 */
class BubbleSort implements SortAlgorithm {

    /**
     * バブルソートの本体です。
     *
     * 配列の左から順に、隣り合う要素を比較して大きい方を右に入れ替えます。
     * これを配列の長さ分だけ繰り返すことで、すべての要素が小さい順に並びます。
     *
     * 途中で1回も入れ替えが発生しなければ、すでに整列済みと判断して終了します。
     *
     * @param array 並べ替えたい配列
     * @param <T> 配列の要素型（Comparableを実装している必要あり）
     * @return 昇順に並べ替えた配列
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        // 配列の先頭から順に、隣り合う要素を比較して入れ替える
        for (int i = 1, size = array.length; i < size; ++i) {
            boolean swapped = false; // このループで1回でも入れ替えがあったか
            for (int j = 0; j < size - i; ++j) {
                // 左の要素が右より大きければ入れ替える
                if (SortUtils.greater(array[j], array[j + 1])) {
                    SortUtils.swap(array, j, j + 1);
                    swapped = true;
                }
            }
            // 1回も入れ替えがなければ終了（すでに整列済み）
            if (!swapped) {
                break;
            }
        }
        return array;
    }
}
