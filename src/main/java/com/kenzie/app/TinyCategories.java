package com.kenzie.app;


import java.util.ArrayList;

//Manually filtered results for all categories with < 5 clues
//Contains two arrays to prevent checking of empty categories, which may cause errors
public class TinyCategories {
    private int[] tinyCategoriesIDs = new int[]{14, 22, 34, 45, 54, 55, 103, 183, 202, 376, 452, 459, 493, 566,
            570, 609, 616, 719, 729, 778, 851, 915, 941, 944, 947, 948, 955, 972, 1038, 1094, 1100,
            1128, 1140, 1149, 1160, 1164, 1175, 1284, 1291, 1342, 1394, 1414, 1539, 1544, 1597, 1614,
            1684, 1687, 1694, 1712, 1714, 1725, 1760, 1849, 1863, 1870, 1889, 1903, 1911, 1916, 1920,
            1933, 1960, 1987, 2063, 2076, 2079, 2115, 2141, 2142, 2151, 2153, 2172, 2177, 2184, 2214,
            2224, 2264, 2455, 2458, 2513, 2532, 2564, 2577, 2613, 2617, 2627, 2676, 2677, 2701, 2725,
            2729, 2768, 2864, 2881, 2951, 2961, 2965, 2967, 2971, 3019, 3023, 3027, 3039, 3172, 3327,
            3328, 3330, 3350, 3352, 3358, 3401, 3403, 3416, 3445, 3448, 3452, 3494, 3526, 3534, 3538,
            3544, 3557, 3567, 3579, 3605, 3627, 3628, 3641, 3785, 3788, 3792, 3798, 3804, 3807, 3840,
            3891, 3894, 3897, 3898, 3931, 3938, 3939, 3941, 3949, 3950, 3953, 3956, 3960, 3966, 3993,
            3997, 4002, 4018, 4022, 4023, 4076, 4126, 4151, 4304, 4332, 4354, 4366, 4386, 4392, 4399,
            4410, 4411, 4497, 4498, 4623, 4721, 4762, 4765, 4801, 4999, 5004, 5014, 5041, 5103, 5139,
            5147, 5430, 5446, 5558, 5586, 5603, 5627, 5642, 5643, 5680, 5685, 5689, 5697, 5725, 5749,
            5757, 5764, 5790, 5791, 5853, 5873, 5948, 6016, 6018, 6060, 6063, 6072, 6109, 6111, 6115,
            6130, 6132, 6133, 6157, 6213, 6260, 6356, 6412, 6500, 6518, 6693, 6716, 6718, 6733, 6734,
            6737, 6784, 6827, 6833, 6849, 6854, 6887, 6901, 6923, 6951, 6959, 7120, 7125, 7218, 7219,
            7296, 7330, 7359, 7383, 7410, 7476, 7512, 7585, 7606, 7623, 7628, 7629, 7637, 7746, 7882,
            7903, 7919, 7961, 8156, 8166, 8200, 8201, 8242, 8257, 8262, 8284, 8306, 8338, 8343, 8355,
            8357, 8360, 8364, 8391, 8392, 8417, 8425, 8444, 8454, 8477, 8528, 8532, 8590, 8610, 8614,
            8670, 8672, 8744, 8746, 8781, 8810, 8822, 8838, 8857, 8858, 8865, 8961, 9029, 9032, 9086,
            9117, 9132, 9137, 9240, 9263, 9289, 9310, 9326, 9346, 9352, 9386, 9396, 9400, 9419, 9432,
            9442, 9489, 9503, 9511, 9516, 9544, 9556, 9573, 9578, 9596, 9598, 9599, 9623, 9624, 9637,
            9679, 9683, 9686, 9702, 9709, 9711, 9734, 9767, 9775, 9777, 9779, 9785, 9796, 9815, 9828,
            9832, 9883, 9946, 9957, 9958, 9962, 9989, 10013, 10052, 10058, 10073, 10084, 10100, 10101,
            10229, 10232, 10234, 10267, 10311, 10318, 10320, 10342, 10345, 10402, 10404, 10424, 10426,
            10428, 10461, 10476, 10478, 10501, 10503, 10538, 10547, 10562, 10565, 10573, 10576, 10599,
            10621, 10654, 10723, 10731, 10734, 10735, 10737, 10753, 10792, 10827, 10845, 10853, 10855,
            10862, 10874, 10978, 10979, 10993, 11046, 11067, 11115, 11116, 11138, 11139, 11140, 11155,
            11168, 11177, 11184, 11186, 11361, 11376, 11427, 11432, 11440, 11441, 11445, 11480, 11503,
            11528, 11546, 11579, 11591, 11592, 11624, 11638, 11640, 11677, 11679, 11681, 11706, 11742,
            11930, 11933, 11960, 11967, 11971, 11980, 11999, 12005, 12007, 12023, 12121, 12185, 12189,
            12192, 12227, 12318, 12324, 12376, 12381, 12384, 12418, 12432, 12433, 12462, 12467, 12504,
            12519, 12524, 12593, 12607, 12608, 12613, 12617, 12626, 12649, 12669, 12783, 12799, 12854,
            12855, 13000, 13002, 13003, 13062, 13097, 13098, 13100, 13101, 13103, 13104, 13105, 13108,
            13117, 13119, 13120, 13121, 13122, 13123, 13136, 13160, 13183, 13206, 13209, 13216, 13220,
            13236, 13242, 13262, 13283, 13286, 13355, 13414, 13430, 13431, 13440, 13443, 13444, 13445,
            13447, 13454, 13458, 13459, 13519, 13552, 13564, 13597, 13600, 13659, 13667, 13676, 13682,
            13724, 13741, 13801, 13802, 13805, 13806, 13815, 13834, 13835, 13846, 13847, 13849, 13901,
            14079, 14080, 14085, 14124, 14221, 14324, 14366, 14370, 14375, 14405, 14406, 14410, 14414,
            14415, 14438, 14490, 14498, 14500, 14558, 14609, 14618, 14625, 14768, 14772, 14827, 14898,
            14972, 14981, 15004, 15007, 15014, 15019, 15025, 15028, 15038, 15041, 15042, 15043, 15050,
            15080, 15095, 15114, 15145, 15156, 15238, 15248, 15250, 15256, 15267, 15275, 15276, 15297,
            15313, 15323, 15324, 15333, 15339, 15348, 15359, 15372, 15384, 15406, 15566, 15601, 15611,
            15615, 15627, 15629, 15632, 15643, 15645, 15651, 15675, 15680, 15691, 15709, 15755, 15801,
            15802, 15825, 15835, 15850, 15903, 15904, 15907, 15917, 15930, 15951, 15953, 16010, 16032,
            16061, 16107, 16129, 16172, 16179, 16182, 16206, 16214, 16226, 16344, 16398, 16519, 16546,
            16549, 16644, 16650, 16658, 16661, 16673, 16680, 16687, 16703, 16704, 16715, 16763, 16797,
            16798, 16859, 16892, 16896, 16904, 16908, 16929, 16948, 17044, 17058, 17061, 17122, 17161,
            17162, 17175, 17178, 17183, 17184, 17185, 17189, 17194, 17199, 17200, 17201, 17203, 17205,
            17208, 17247, 17280, 17283, 17321, 17331, 17332, 17336, 17345, 17358, 17360, 17372, 17373,
            17375, 17389, 17390, 17392, 17436, 17437, 17438, 17477, 17478, 17482, 17483, 17487, 17548,
            17573, 17602, 17604, 17608, 17609, 17612, 17613, 17615, 17627, 17630, 17633, 17638, 17643,
            17673, 17674, 17717, 17810, 17821, 17822, 17824, 17847, 17853, 17884, 17937, 17980, 18002,
            18007, 18015, 18022, 18035, 18037, 18080, 18094, 18099, 18104, 18109, 18112, 18124, 18163,
            18214, 18296, 18309, 18311, 18362, 18374, 18420, 18422, 18433, 18434, 18444, 18451, 18452,
            18453, 18626, 18627, 18656, 18662, 18740, 18746, 18752, 18785, 18829, 18864, 18890, 18903,
            18906, 18926, 18931, 18949, 18956, 18991, 18992, 19024, 19031, 19033, 19034, 19037, 19074,
            19095, 19120, 19124, 19126, 19134, 19140, 19163, 19182, 19190, 19245, 19269, 19275, 19277,
            19307, 19321, 19338, 19415, 19418, 19424, 19501, 19511, 19525, 19543, 19559, 19562, 19566,
            19579, 19603, 19642, 19677, 19706, 19752, 19754, 19773, 19823, 19854, 19866, 19869, 19871,
            19873, 19877, 19884, 19886, 19901, 19902, 19926, 19928, 19929, 19944, 19945, 19946, 19974,
            19979, 19983, 19987, 20023, 20053, 20113, 20128, 20141, 20145, 20165, 20176, 20201, 20204,
            20236, 20277, 20295, 20331, 20426, 20442, 20457, 20465, 20477, 20479, 20549, 20551, 20561,
            20572, 20574, 20575, 20589, 20593, 20599, 20600, 20624, 20627, 20628, 20633, 20637, 20643,
            20660, 20672, 20678, 20687, 20697, 20702, 20704, 20709, 20719, 20734, 20740, 20754, 20761,
            20764, 20782, 20792, 20818, 20822, 20837, 20838, 20846, 20847, 20866, 20882, 20884, 20892,
            20900, 20921, 20927, 20959, 20960, 20961, 20967, 21065, 21084, 21108, 21111, 21125, 21136,
            21151, 21159, 21160, 21168, 21173, 21182, 21225, 21234, 21267, 21295, 21311, 21331, 21351,
            21352, 21387, 21399, 21415, 21428, 21433, 21447, 21449, 21464, 21466, 21496, 21498, 21509,
            21516, 21521, 21567, 21575, 21576, 21583, 21585, 21602, 21692, 21716, 21719, 21754, 21764,
            21778, 21788, 21790, 21797, 21811, 21816, 21829, 21830, 21883, 21917, 21919, 21925, 21938,
            21940, 21970, 22014, 22036, 22079, 22179, 22322, 22371, 22373, 22419, 22425, 22439, 22443,
            22444, 22452, 22497, 22499, 22500, 22515, 22537, 22545, 22549, 22556, 22633, 22724, 22748,
            22801, 22821, 22962, 22972, 22973, 22994, 22996, 23166, 23183, 23187, 23204, 23217, 23225,
            23247, 23254, 23274, 23310, 23339, 23345, 23367, 23372, 23379, 23385, 23395, 23397, 23404,
            23429, 23462, 23471, 23472, 23491, 23492, 23494, 23498, 23524, 23531, 23538, 23540, 23555,
            23595, 23743, 23748, 23750, 23807, 23821, 23825, 23844, 23855, 23862, 23904, 23927, 23945,
            23967, 23974, 23976, 23978, 23984, 23985, 24002, 24035, 24042, 24065, 24069, 24075, 24080,
            24085, 24098, 24106, 24109, 24113, 24154, 24215, 24216, 24220, 24221, 24223, 24227, 24234,
            24239, 24240, 24244, 24246, 24247, 24250, 24283, 24286, 24287, 24288, 24291, 24325, 24328,
            24329, 24332, 24333, 24341, 24343, 24381, 24405, 24416, 24425, 24433, 24461, 24486, 24490,
            24508, 24540, 24554, 24555, 24556, 24560, 24561, 24569, 24571, 24579, 24587, 24611, 24623,
            24628, 24633, 24646, 24649, 24659, 24662, 24673, 24685, 24689, 24692, 24706, 24707, 24711,
            24724, 24727, 24798, 24802, 24804, 24808, 24827, 24836, 24850, 24858, 24863, 24865, 24867,
            24868, 24896, 24898, 24905, 24916, 24931, 24951, 24958, 24978, 24981, 25004, 25013, 25020,
            25025, 25026, 25035, 25041, 25059, 25061, 25063, 25075, 25077, 25092, 25102, 25144, 25199,
            25220, 25226, 25237, 25256, 25266, 25297, 25298, 25310, 25325, 25338, 25348, 25361, 25377,
            25380, 25389, 25394, 25401, 25405, 25435, 25444, 25448, 25463, 25466, 25525, 25526, 25558,
            25711, 25712, 25714, 25762, 25772, 25801, 25853, 25856, 25876, 26010, 26039, 26100, 26128,
            26137, 26157, 26159, 26175, 26182, 26219, 26230, 26250, 26254, 26273, 26288, 26291, 26294,
            26305, 26311, 26325, 26378, 26420, 26430, 26454, 26473, 26503, 26504, 26518, 26519, 26544,
            26605, 26606, 26624, 26634, 26635, 26649, 26657, 26659, 26680, 26723, 26726, 26758, 26760,
            26762, 26771, 26775, 26788, 26793, 26797, 26804, 26807, 26810, 26820, 26832, 26843, 26853,
            26893, 26901, 26913, 26914, 26929, 26932, 26937, 26942, 26956, 26981, 26982, 27017, 27053,
            27054, 27057, 27074, 27083, 27096, 27108, 27110, 27128, 27131, 27133, 27134, 27141, 27145,
            27150, 27156, 27162, 27201, 27211, 27219, 27221, 27225, 27232, 27239, 27245, 27253, 27257,
            27270, 27274, 27286, 27313, 27314, 27321, 27323, 27325, 27331, 27332, 27333, 27344, 27349,
            27350, 27366, 27416, 27420, 27436, 27486, 27497, 27524, 27525, 27526, 27539, 27549, 27557,
            27562, 27568, 27575, 27585, 27596, 27602, 27627, 27636, 27649, 27665, 27668, 27676, 27680,
            27684, 27688, 27692, 27709, 27738, 27740, 27762, 27766, 27775, 27805, 27808, 27813, 27818,
            27819, 27828, 27834, 27835, 27855, 27857, 27883, 27904, 27923, 27929, 27950, 27954, 28137,
            28139, 28163, 28190, 28203, 28245, 28254, 28260, 28268, 28274, 28294, 28301, 28347, 28361,
            28399, 28423, 28427, 28439, 28443, 28446, 28480, 28496, 28500, 28508, 28584, 28623, 28666,
            28689, 28707, 28716, 28718, 28789, 28960, 28967, 28985, 29001, 29008, 29009, 29032, 29062,
            29063, 29080, 29130, 29147, 29154, 29171, 29179, 29187, 29190, 29193, 29204, 29210, 29240,
            29247, 29248, 29353, 29354, 29398, 29428, 29432, 29437, 29440, 29452, 29458, 29473, 29474,
            29476, 29490, 29492, 29498, 29502, 29565, 29580, 29584, 29589, 29591, 29614, 29625, 29629,
            29637, 29642, 29655, 29657, 29667, 29671, 29697, 29709, 29727, 29733, 29748, 29756, 29775,
            29779, 29789, 29790, 29813, 29815, 29817, 29838, 29861, 29864, 29869, 29873, 29895, 29900,
            29901, 29904, 29912, 29923, 29924, 29937, 29938, 29947, 29950, 29951, 29964, 29970, 30076,
            30091, 30096, 30097, 30104, 30112, 30119, 30135, 30136, 30168, 30174, 30182, 30207, 30210,
            30213, 30217, 30236, 30244, 30266, 30272, 30278, 30280, 30286, 30287, 30298, 30315, 30328,
            30331, 30335, 30348, 30366, 30375, 30376, 30377, 30385, 30396, 30400, 30403, 30409, 30418,
            30420, 30446, 30451, 30455, 30462, 30582, 30609, 30620, 30626, 30634, 30642, 30654, 30655,
            30710, 30713, 30724, 30727, 30734, 30754, 30757, 30783, 30791, 30796, 30800, 30804, 30806,
            30820, 30828, 30829, 30848, 30864, 30865, 30885, 30908, 30926, 30927, 30928, 30960, 30961,
            30965, 30969, 30970, 30982, 30984, 30996, 31007, 31018, 31022, 31043, 31045, 31049, 31052,
            31068, 31082, 31084, 31100, 31112, 31114, 31116, 31117, 31136, 31142, 31150, 31154, 31158,
            31160, 31161, 31169, 31193, 31195, 31199, 31202, 31206, 31209, 31221, 31222, 31227, 31237,
            31249, 31264, 31272, 31284, 31288, 31295, 31302, 31303, 31348, 31363, 31378, 31379, 31390,
            31396, 31407, 31421, 31423, 31455, 31465, 31469, 31491, 31501, 31502, 31508, 31518, 31520,
            31522, 31529, 31531, 31607, 31611, 31614, 31615, 31617, 31618, 31620, 31622, 31623, 31632,
            31637, 31641, 31656, 31658, 31663, 31690, 31700, 31705, 31737, 31767, 31770, 31778, 31779,
            31785, 31796, 31799, 31801, 31820, 31823, 31827, 31828, 31831, 31841, 31862, 31865, 31870,
            31877, 31882, 31888, 31891, 31899, 31911, 31913, 31915, 31916, 31921, 31922, 31923, 31968,
            31969, 31971, 31998, 32004, 32008, 32013, 32014, 32020, 32021, 32028, 32029, 32030, 32045,
            32047, 32048, 32052, 32053, 32057, 32067, 32069, 32073, 32094, 32106, 32132, 32141, 32144,
            32149, 32152, 32153, 32158, 32171, 32174, 32185, 32190, 32193, 32277, 32300, 32304, 32307,
            32308, 32312, 32325, 32329, 32330, 32336, 32337, 32338, 32346, 32349, 32350, 32354, 32358,
            32370, 32373, 32393, 32394, 32395, 32408, 32436, 32440, 32445, 32449, 32456, 32472, 32473,
            32484, 32493, 32494, 32498, 32503, 32505, 32513, 32515, 32524, 32528, 32529, 32534, 32536,
            32540, 32541, 32548, 32551, 32557, 32563, 32575, 32578, 32583, 32587, 32588, 32609, 32613,
            32631, 32641, 32644, 32646, 32654, 32667, 32669, 32670, 32676, 32680, 32685, 32686, 32695,
            32710, 32711, 32717, 32719, 32727, 32746, 32756, 32810, 32811, 32812, 32813, 32814, 32838,
            32840, 32844, 32850, 32857, 32859, 32899, 32943, 32944, 32985, 32991, 32995, 32996, 33010,
            33013, 33019, 33022, 33023, 33024, 33026, 33027, 33029, 33034, 33035, 33036, 33037, 33041,
            33046, 33047, 33048, 33057, 33060, 33076, 33093, 33133, 33134, 33140, 33150, 33157, 33164,
            33197, 33198, 33199, 33241, 33255, 33269, 33274, 33298, 33302, 33339, 33395, 33399, 33404,
            33432, 33440, 33442, 33443, 33445, 33447, 33449, 33452, 33453, 33458, 33459, 33460, 33467,
            33476, 33489, 33504, 33527, 33544, 33547, 33573, 33595, 33598, 33599, 33626, 33639, 33650,
            33700, 33732, 33738, 33741, 33755, 33757, 33763, 33764, 33773, 33801, 33802, 33804, 33807,
            33810, 33812, 33814, 33831, 33832, 33837, 33838, 33842, 33861, 33865, 33882, 33885, 33886,
            33887, 33889, 33891, 33936, 33939, 33954, 33955, 33966, 33969, 33976, 33981, 33982, 34005,
            34034, 34041, 34049, 34071, 34074, 34080, 34083, 34085, 34095, 34101, 34131, 34140, 34153,
            34155, 34163, 34190, 34202, 34209, 34222, 34227, 34230, 34234, 34236, 34243, 34251, 34252,
            34261, 34266, 34268, 34276, 34328, 34340, 34354, 34356, 34431, 34432, 34443, 34445, 34453,
            34463, 34468, 34476, 34478, 34485, 34486, 34487, 34497, 34503, 34520, 34525, 34528, 34537,
            34541, 34555, 34567, 34583, 34590, 34653, 34658, 34665, 34666, 34669, 34675, 34687, 34709,
            34730, 34732, 34737, 34741, 34751, 34753, 34756, 34764, 34781, 34793, 34806, 34809, 34812,
            34825, 34852, 34859, 34873, 34883, 34967, 34990, 34992, 34997, 35006, 35011, 35019, 35023,
            35026, 35031, 35035, 35036, 35039, 35049, 35061, 35063, 35067, 35071, 35073, 35078, 35081,
            35091, 35094, 35102, 35110, 35111, 35114, 35116, 35122, 35123, 35127, 35147, 35172, 35197,
            35201, 35215, 35224, 35238, 35246, 35257, 35261, 35263, 35273, 35289, 35303, 35304, 35309,
            35312, 35320, 35325, 35333, 35336, 35342, 35343, 35374, 35376, 35384, 35389, 35395, 35405,
            35429, 35431, 35434, 35446, 35450, 35469, 35487, 35488, 35525, 35540, 35545, 35569, 35580,
            35596, 35644, 35645, 35663, 35674, 35678, 35699, 35700, 35703, 35709, 35710, 35724, 35726,
            35731, 35734, 35735, 35736, 35766, 35775, 35805, 35819, 35830, 35851, 35871, 35878, 35879,
            35897, 35908, 35910, 35914, 35922, 35923, 35927, 35945, 35947, 35951, 35981, 35984, 35986,
            35988, 36040, 36052, 36118, 36121, 36124, 36125, 36132, 36133, 36134, 36138, 36142, 36148,
            36149, 36189, 36202, 36206, 36214, 36218, 36228, 36233, 36234, 36248, 36264, 36267, 36287,
            36359, 36360, 36381, 36388, 36390, 36409, 36414, 36436, 36446, 36458, 36459, 36466, 36474,
            36475, 36536, 36547, 36561, 36562, 36563, 36577, 36580, 36591, 36597, 36616, 36618, 36624,
            36630, 36655, 36658, 36670, 36675, 36682, 36689, 36710, 36713, 36740, 36743, 36746, 36760,
            36762, 36764, 36778, 36786, 36800, 36807, 36815, 36817, 36827, 36831, 36835, 36841, 36844,
            36845, 36852, 36855, 36856, 36863, 36866, 36879, 36885, 36889, 36898, 36905, 36917, 36924,
            36925, 36959, 36969, 36977, 37001, 37002, 37007, 37035, 37039, 37049, 37055, 37065, 37068,
            37080, 37082, 37098, 37106, 37118, 37120, 37121, 37122, 37126, 37129, 37130, 37134, 37135,
            37139, 37143, 37149, 37150, 37151, 37152, 37154, 37155, 37156, 37157, 37168, 37172, 37173,
            37174, 37181, 37183, 37193, 37202, 37207, 37217, 37221, 37224, 37248, 37265, 37295, 37308,
            37316, 37320, 37321, 37324, 37325, 37329, 37332, 37342, 37347, 37371, 37376, 37377, 37378,
            37380, 37406, 37435, 37445, 37498, 37514, 37528, 37533, 37539, 37555, 37556, 37559, 37561,
            37570, 37572, 37667, 37668, 37669, 37701, 37704, 37715, 37725, 37733, 37745, 37749, 37759,
            37763, 37769, 37790, 37805, 37811, 37906, 37920, 37923, 37928, 37956, 38016, 38028, 38046,
            38060, 38082, 38100, 38108, 38122, 38125, 38130, 38170, 38188, 38211, 38213, 38216, 38217,
            38225, 38226, 38229, 38240, 38258, 38267, 38272, 38312, 38317, 38321, 38324, 38334, 38352,
            38380, 38395, 38403, 38408, 38421, 38444, 38461, 38482, 38487, 38490, 38494, 38498, 38521,
            38524, 38525, 38530, 38536, 38541, 38550, 38556, 38558, 38562, 38570, 38579, 38591, 38605,
            38608, 38610, 38614, 38622, 38686, 38692, 38701, 38715, 38716, 38719, 38727, 38729, 38732,
            38734, 38739, 38741, 38760, 38764, 38782, 38783, 38786, 38790, 38806, 38808, 38813, 38821,
            38822, 38868, 38870, 38889, 38891, 38901, 38902, 38924, 38925, 38926, 38951, 38954, 38963,
            38967, 38986, 39056, 39057, 39077, 39091, 39096, 39136, 39154, 39209, 39215, 39243, 39244,
            39255, 39289, 39315, 39319, 39330, 39366, 39458, 39471, 39479, 39481, 39488, 39529, 39544,
            39563, 39564, 39620, 39625, 39629, 39642, 39647, 39665, 39669, 39670, 39687, 39688, 39694,
            39707, 39721, 39724, 39736, 39743, 39750, 39759, 39774, 39777, 39779, 39797, 39805, 39816,
            39818, 39885, 39907, 39924, 39944, 39947, 39963, 39966, 39981, 39987, 40008, 40014, 40019,
            40027, 40032, 40076, 40093, 40098, 40121, 40151, 40162, 40172, 40173, 40178, 40180, 40182,
            40187, 40188, 40191, 40216, 40219, 40220, 40237, 40251, 40277, 40292, 40295, 40302, 40310,
            40321, 40324, 40333, 40357, 40365, 40378, 40387, 40443, 40462, 40466, 40482, 40506, 40530,
            40535, 40537, 40543, 40548, 40551, 40563, 40565, 40585, 40621, 40628, 40629, 40630, 40631,
            40632, 40637, 40662, 40678, 40679, 40681, 40687, 40690, 40727, 40741, 40742, 40786, 40796,
            40797, 40887, 40898, 40915, 40930, 40933, 40939, 40941, 40949};

    private int[] emptyCategoriesIDs = new int[]{323, 3648, 3649, 3650, 3786, 3793, 3808, 3927, 3951, 3955, 7213,
            8575, 8594, 8866, 8981, 13424, 13425, 13669, 17218, 17333, 21420, 21971, 24345, 24828, 25460,
            26619, 27016, 28999, 31111, 31137, 31344, 31414, 31780, 31781, 31782, 31783, 32387, 32391,
            32489, 32835, 32860, 33200, 34025, 35485, 35919, 38099, 38222, 40556, 40598, 40599};

    public int[] getTinyCategoriesIDs() {
        return tinyCategoriesIDs;
    }

    public int[] getEmptyCategoriesIDs() {
        return emptyCategoriesIDs;
    }

    public ArrayList<Integer> undesirableCategoriesIDs() {
        ArrayList<Integer> undesirableCatID = new ArrayList<>();

        for (int tinyCategoriesID : tinyCategoriesIDs) {
            undesirableCatID.add(tinyCategoriesID + 1);
        }

        for (int emptyCategoriesID : emptyCategoriesIDs) {
            undesirableCatID.add(emptyCategoriesID + 1);
        }

        return undesirableCatID;
    }
}