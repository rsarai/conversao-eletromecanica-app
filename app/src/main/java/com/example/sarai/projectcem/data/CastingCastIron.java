package com.example.sarai.projectcem.data;

import java.util.ArrayList;
import java.util.List;

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

    public static double timeVariable = 0.0001;

    public double instantaneousFlow(double timeVariable) {
        return 0.00145892031 * Math.sin(120 * Math.PI * timeVariable);
    }

    public double getDensityFlow(double flow, double areaSecaoTransversalNucleo) {
        return flow / areaSecaoTransversalNucleo;
    }

    public double getChain(double intensity_of_flow, double lComprimentomMedioNucleo, double Np) {
        return (intensity_of_flow * lComprimentomMedioNucleo)/Np;
    }

    public double getH(double b) {
        for (int j = 0; j < HBDATA.length; j++) {
            //se b estiver entre os 2 pontos de b da curva bh listada abaixo, é feita uma eq da reta
            //pra determinar um valor aproximado de h. Lembrando que o valor de b na lista abaixo
            // está na segunda posição do array
            if (b < HBDATA[j + 1][1]) {
                return interpolacao(HBDATA[j], HBDATA[j + 1], b);
            }
        }
        return 0;
    }

    public double interpolacao(double[] p1, double[] p2, double value) {
        //encontrar a equacao da reta y = mx + b e encontrar o valor de H nessa reta partindo do valor
        double m = (p2[0] - p1[0]) / (p2[1] - p1[1]); // m = y2 - y1 / x2 - x1
        double b = p1[0] - p1[1] * m; // b = y - mx

        return value * m + b; // retorna y(value)
    }

    public List<Double> getGraphParametersTimeDomain(){
        List<Double> timeDomain = new ArrayList<>();

        for (int i = 0; i < 1000; i++){
            double time = timeVariable * i / 1000.0;
            timeDomain.add(time);
        }
        return timeDomain;
    }

    public List<Double> getGraphParametersCorrenteDomain(double areaSecaoTransversalNucleo,
                                                        double lComprimentomMedioNucleo, double Np){
        List<Double> correnteDomain = new ArrayList<>();

        for (int i = 0; i < 1000; i++){
            int flag = 1;
            double time = timeVariable * i / 1000.0;
            double valueInstantaneousFlow = instantaneousFlow(time);
            double b = getDensityFlow(valueInstantaneousFlow, areaSecaoTransversalNucleo);

            if (b < 0) {
                flag = -1;
                b = b * flag;
            }

            double h = getH(b);
            correnteDomain.add(getChain(h, lComprimentomMedioNucleo, Np) * flag);
        }

        return correnteDomain;
    }
}