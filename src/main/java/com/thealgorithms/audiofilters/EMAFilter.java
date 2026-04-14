package com.thealgorithms.audiofilters;

/**
 * 音声信号を平滑化するための指数移動平均（EMA）フィルタ。
 *
 * <p>このフィルタは、音声信号の値列に指数移動平均を適用し、急激な変動をなめらかにするのに役立ちます。
 * 平滑化係数（alpha）によって平滑化の度合いを調整します。
 *
 * <p>定義は
 * <a href="https://ja.wikipedia.org/wiki/%E7%A7%AF%E5%88%86%E5%B9%B3%E5%9D%87">Wikipedia（移動平均）</a>に基づきます。
 */
public class EMAFilter {
    private final double alpha;
    private double emaValue;
    /**
     * 指定した平滑化係数でEMAフィルタを生成します。
     *
     * @param alpha 平滑化係数（0 < alpha <= 1）
     * @throws IllegalArgumentException alphaが(0, 1]の範囲外の場合
     */
    public EMAFilter(double alpha) {
        if (alpha <= 0 || alpha > 1) {
            throw new IllegalArgumentException("Alpha must be between 0 and 1.");
        }
        this.alpha = alpha;
        this.emaValue = 0.0;
    }
    /**
     * 音声信号配列にEMAフィルタを適用します。
     *
     * @param audioSignal 処理対象の音声サンプル配列
     * @return 平滑化されたサンプル配列
     */
    public double[] apply(double[] audioSignal) {
        if (audioSignal.length == 0) {
            return new double[0];
        }
        double[] emaSignal = new double[audioSignal.length];
        emaValue = audioSignal[0];
        emaSignal[0] = emaValue;
        for (int i = 1; i < audioSignal.length; i++) {
            emaValue = alpha * audioSignal[i] + (1 - alpha) * emaValue;
            emaSignal[i] = emaValue;
        }
        return emaSignal;
    }
}
