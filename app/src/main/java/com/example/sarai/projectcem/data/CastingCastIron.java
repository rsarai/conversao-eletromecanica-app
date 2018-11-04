package com.example.sarai.projectcem.data;

public class CastingCastIron {
    public static double[][] HBDATA = {
            {0, 0.000},
            {3, 0.004},
            {6, 0.008},
            {11, 0.014},
            {17, 0.023},
            {25, 0.035},
            {35, 0.050},
            {47, 0.068},
            {59, 0.090},
            {73, 0.114},
            {86, 0.140},
            {100, 0.168},
            {112, 0.196},
            {136, 0.250},
            {157, 0.300},
            {199, 0.392},
            {222, 0.437},
            {301, 0.562},
            {419, 0.695},
            {564, 0.813},
            {619, 0.850},
            {768, 0.929},
            {955, 1.000},
            {1039, 1.025},
            {1408, 1.100},
            {1784, 1.149},
            {1995, 1.171},
            {2626, 1.222},
            {3106, 1.250},
            {5440, 1.325},
            {6885, 1.362},
            {9128, 1.403},
            {10539, 1.426},
            {15323, 1.490},
            {21719, 1.550},
            {27452, 1.588},
            {34628, 1.625},
            {43626, 1.662},
            {58218, 1.711},
            {73137, 1.744},
            {95813, 1.790},
            {101557, 1.801},
            {109710, 1.814},
            {112872, 1.819},
            {116398, 1.824},
            {123026, 1.832},
    };

    public static double areaSecaoTransversalNucleo = 0.0008;
    public static double lComprimentomMedioNucleo = 0.35;
    public static double Np = 860;
    public static int iterations = 1000;

    public double get_density_of_flow(double flow) {
        return flow / areaSecaoTransversalNucleo;
    }

    public double get_chain(double intensity_of_flow) {
        return (intensity_of_flow * lComprimentomMedioNucleo)/Np;
    }
}