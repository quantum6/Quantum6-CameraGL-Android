package net.quantum6.cameragl.video;

import android.hardware.Camera;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;



/**
 * @author l00385426
 * @version 1.0
 * @date 2017/3/1
 */

public class CameraUtil {

    public static boolean equalRate(Camera.Size s, float rate) {
        float r = (float) (s.width) / (float) (s.height);
        if (Math.abs(r - rate) <= 0.03) {
            return true;
        } else {
            return false;
        }
    }

    public static Camera.Size chooseOptimalSize(List<Camera.Size> list, float th, int minWidth) {
        Collections.sort(list, new CameraSizeComparator());

        int i = 0;
        for (Camera.Size s : list) {
            LOG.logI("PreviewSize:w = " + s.width + "h = " + s.height);
            if ((s.width >= minWidth) && equalRate(s, th)) {

                break;
            }
            i++;
        }
        if (i == list.size()) {
            LOG.logE("鎵句笉鍒板悎閫傜殑棰勮灏哄锛侊紒锛�");
            i = 0;//濡傛灉娌℃壘鍒帮紝灏遍�夋渶灏忕殑size
        }
        return list.get(i);
    }


    // 涓篠ize瀹氫箟涓�涓瘮杈冨櫒Comparator
    public static class CameraSizeComparator implements Comparator<Camera.Size> {
        public int compare(Camera.Size lhs, Camera.Size rhs) {
            // TODO Auto-generated method stub
            if (lhs.width == rhs.width) {
                return 0;
            } else if (lhs.width > rhs.width) {
                return 1;
            } else {
                return -1;
            }
        }

    }
}
