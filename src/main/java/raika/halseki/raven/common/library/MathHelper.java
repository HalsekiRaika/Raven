package raika.halseki.raven.common.library;

import raika.halseki.raven.common.library.math.VectorProperty;

public class MathHelper {
    public static double pySum(VectorProperty vector) {
        return Math.sqrt(vector.getVecX() * vector.getVecX()
                + vector.getVecY() * vector.getVecY()
                + vector.getVecZ() * vector.getVecZ()
        );
    }

}
