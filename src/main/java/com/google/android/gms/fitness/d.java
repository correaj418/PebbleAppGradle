package com.google.android.gms.fitness;

public class d {
    private static final String[] a = new String[119];

    static {
        a[9] = "aerobics";
        a[10] = "badminton";
        a[11] = "baseball";
        a[12] = "basketball";
        a[13] = "biathlon";
        a[1] = "biking";
        a[14] = "biking.hand";
        a[15] = "biking.mountain";
        a[16] = "biking.road";
        a[17] = "biking.spinning";
        a[18] = "biking.stationary";
        a[19] = "biking.utility";
        a[20] = "boxing";
        a[21] = "calisthenics";
        a[22] = "circuit_training";
        a[23] = "cricket";
        a[113] = "crossfit";
        a[106] = "curling";
        a[24] = "dancing";
        a[102] = "diving";
        a[117] = "elevator";
        a[25] = "elliptical";
        a[103] = "ergometer";
        a[118] = "escalator";
        a[6] = "exiting_vehicle";
        a[26] = "fencing";
        a[27] = "football.american";
        a[28] = "football.australian";
        a[29] = "football.soccer";
        a[30] = "frisbee_disc";
        a[31] = "gardening";
        a[32] = "golf";
        a[33] = "gymnastics";
        a[34] = "handball";
        a[114] = "interval_training.high_intensity";
        a[35] = "hiking";
        a[36] = "hockey";
        a[37] = "horseback_riding";
        a[38] = "housework";
        a[104] = "ice_skating";
        a[0] = "in_vehicle";
        a[115] = "interval_training";
        a[39] = "jump_rope";
        a[40] = "kayaking";
        a[41] = "kettlebell_training";
        a[107] = "kick_scooter";
        a[42] = "kickboxing";
        a[43] = "kitesurfing";
        a[44] = "martial_arts";
        a[45] = "meditation";
        a[46] = "martial_arts.mixed";
        a[2] = "on_foot";
        a[108] = "other";
        a[47] = "p90x";
        a[48] = "paragliding";
        a[49] = "pilates";
        a[50] = "polo";
        a[51] = "racquetball";
        a[52] = "rock_climbing";
        a[53] = "rowing";
        a[54] = "rowing.machine";
        a[55] = "rugby";
        a[8] = "running";
        a[56] = "running.jogging";
        a[57] = "running.sand";
        a[58] = "running.treadmill";
        a[59] = "sailing";
        a[60] = "scuba_diving";
        a[61] = "skateboarding";
        a[62] = "skating";
        a[63] = "skating.cross";
        a[105] = "skating.indoor";
        a[64] = "skating.inline";
        a[65] = "skiing";
        a[66] = "skiing.back_country";
        a[67] = "skiing.cross_country";
        a[68] = "skiing.downhill";
        a[69] = "skiing.kite";
        a[70] = "skiing.roller";
        a[71] = "sledding";
        a[72] = "sleep";
        a[109] = "sleep.light";
        a[110] = "sleep.deep";
        a[111] = "sleep.rem";
        a[112] = "sleep.awake";
        a[73] = "snowboarding";
        a[74] = "snowmobile";
        a[75] = "snowshoeing";
        a[76] = "squash";
        a[77] = "stair_climbing";
        a[78] = "stair_climbing.machine";
        a[79] = "standup_paddleboarding";
        a[3] = "still";
        a[80] = "strength_training";
        a[81] = "surfing";
        a[82] = "swimming";
        a[83] = "swimming.pool";
        a[84] = "swimming.open_water";
        a[85] = "table_tennis";
        a[86] = "team_sports";
        a[87] = "tennis";
        a[5] = "tilting";
        a[88] = "treadmill";
        a[4] = "unknown";
        a[89] = "volleyball";
        a[90] = "volleyball.beach";
        a[91] = "volleyball.indoor";
        a[92] = "wakeboarding";
        a[7] = "walking";
        a[93] = "walking.fitness";
        a[94] = "walking.nordic";
        a[95] = "walking.treadmill";
        a[116] = "walking.stroller";
        a[96] = "water_polo";
        a[97] = "weightlifting";
        a[98] = "wheelchair";
        a[99] = "windsurfing";
        a[100] = "yoga";
        a[101] = "zumba";
    }

    public static int a(String str) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(str)) {
                return i;
            }
        }
        return 4;
    }
}
