package topcoder.contests701_800.srm767;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MahdiJumpingTest {

  private MahdiJumping sut;

  @Before
  public void setup() {
    sut = new MahdiJumping();
  }

  @Test(timeout = 3000) public void test1() { assertEquals(sut.minDis(7, 1, 1, 1, 5), 6); }
  @Test(timeout = 3000) public void test2() { assertEquals(sut.minDis(5, 2, 2, 1, 2), 3); }
  @Test(timeout = 3000) public void test3() { assertEquals(sut.minDis(5, 5, 5, 5, 5), 20); }
  @Test(timeout = 3000) public void test4() { assertEquals(sut.minDis(5000000, 314, 5, 1, 2), 31); }
  @Test(timeout = 3000) public void test5() { assertEquals(sut.minDis(5000000, 5, 5, 5, 5), 175); }
  @Test(timeout = 3000) public void test6() { assertEquals(sut.minDis(5000000, 1, 0, 1, 1), 4999999); }
  @Test(timeout = 3000) public void test7() { assertEquals(sut.minDis(5000000, 2, 0, 1, 10), 209); }
  @Test(timeout = 3000) public void test8() { assertEquals(sut.minDis(1, 4, 7, 4, 7), 0); }
  @Test(timeout = 3000) public void test9() { assertEquals(sut.minDis(36865, 15624, 442221, 453, 4431), 22452); }
  @Test(timeout = 3000) public void test10() { assertEquals(sut.minDis(137274, 8, 502, 133466, 1899), 508641); }
  @Test(timeout = 3000) public void test11() { assertEquals(sut.minDis(3021, 112601, 24315, 3, 3448), 3847); }
  @Test(timeout = 3000) public void test12() { assertEquals(sut.minDis(2919165, 137, 26, 13, 463249), 741267); }
  @Test(timeout = 3000) public void test13() { assertEquals(sut.minDis(1578808, 11, 1471, 39986, 13976), 477508); }
  @Test(timeout = 3000) public void test14() { assertEquals(sut.minDis(12107, 199646, 2212, 53228, 469488), 2632708); }
  @Test(timeout = 3000) public void test15() { assertEquals(sut.minDis(5905, 643758, 1482867, 8072, 332), 25440); }
  @Test(timeout = 3000) public void test16() { assertEquals(sut.minDis(270108, 37, 6, 127993, 14181), 881042); }
  @Test(timeout = 3000) public void test17() { assertEquals(sut.minDis(48, 2038033, 1709164, 1, 108), 47); }
  @Test(timeout = 3000) public void test18() { assertEquals(sut.minDis(179310, 62, 80, 10, 442527), 471917); }
  @Test(timeout = 3000) public void test19() { assertEquals(sut.minDis(1871415, 12, 16398, 1305216, 9292), 7826960); }
  @Test(timeout = 3000) public void test20() { assertEquals(sut.minDis(34126, 277, 21, 129890, 127), 161894); }
  @Test(timeout = 3000) public void test21() { assertEquals(sut.minDis(1999825, 267380, 5, 26, 1146483), 1212341); }
  @Test(timeout = 3000) public void test22() { assertEquals(sut.minDis(2298, 5104, 1, 567, 211724), 229301); }
  @Test(timeout = 3000) public void test23() { assertEquals(sut.minDis(2667, 202679, 608911, 519702, 1130), 581852); }
  @Test(timeout = 3000) public void test24() { assertEquals(sut.minDis(233, 13987, 1012, 670723, 4), 670815); }
  @Test(timeout = 3000) public void test25() { assertEquals(sut.minDis(500048, 1, 296847, 1013, 80495), 4406331); }
  @Test(timeout = 3000) public void test26() { assertEquals(sut.minDis(3490, 1365, 17124, 313621, 4024309), 17404484); }
  @Test(timeout = 3000) public void test27() { assertEquals(sut.minDis(407260, 1098454, 180692, 3301146, 3), 26409288); }
  @Test(timeout = 3000) public void test28() { assertEquals(sut.minDis(4121671, 4656, 15, 225958, 425563), 7392689); }
  @Test(timeout = 3000) public void test29() { assertEquals(sut.minDis(184777, 1240351, 12, 6821, 225475), 853771); }
  @Test(timeout = 3000) public void test30() { assertEquals(sut.minDis(151, 971114, 2253, 2279, 6290), 27986); }
  @Test(timeout = 3000) public void test31() { assertEquals(sut.minDis(5821, 726, 26198, 30816, 1136), 91168); }
  @Test(timeout = 3000) public void test32() { assertEquals(sut.minDis(501, 1, 15686, 122929, 794529), 6686102); }
  @Test(timeout = 3000) public void test33() { assertEquals(sut.minDis(9871, 638, 59, 2042, 12034), 60606); }
  @Test(timeout = 3000) public void test34() { assertEquals(sut.minDis(1600339, 1071, 922034, 1008547, 712507), 12759885); }
  @Test(timeout = 3000) public void test35() { assertEquals(sut.minDis(71145, 43, 606006, 59704, 2), 119444); }
  @Test(timeout = 3000) public void test36() { assertEquals(sut.minDis(354371, 941509, 1, 7, 1), 51); }
  @Test(timeout = 3000) public void test37() { assertEquals(sut.minDis(1001519, 1831233, 14, 9, 14941), 28450); }
  @Test(timeout = 3000) public void test38() { assertEquals(sut.minDis(2534462, 707611, 4188288, 61554, 622565), 4268301); }
  @Test(timeout = 3000) public void test39() { assertEquals(sut.minDis(108448, 11413, 1837, 5, 54595), 58325); }
  @Test(timeout = 3000) public void test40() { assertEquals(sut.minDis(192, 38843, 2169, 4762, 759419), 826087); }
  @Test(timeout = 3000) public void test41() { assertEquals(sut.minDis(1490618, 99310, 628, 147442, 693), 525486); }
  @Test(timeout = 3000) public void test42() { assertEquals(sut.minDis(777321, 7979, 1, 770967, 1833120), 21603663); }
  @Test(timeout = 3000) public void test43() { assertEquals(sut.minDis(214, 5, 317660, 174, 5), 229); }
  @Test(timeout = 3000) public void test44() { assertEquals(sut.minDis(1401211, 36, 5, 468600, 2546), 1306370); }
  @Test(timeout = 3000) public void test45() { assertEquals(sut.minDis(208371, 188624, 3552225, 6, 8), 88); }
  @Test(timeout = 3000) public void test46() { assertEquals(sut.minDis(1301, 1210, 1902, 111693, 121307), 1276693); }
  @Test(timeout = 3000) public void test47() { assertEquals(sut.minDis(490754, 3829876, 34254, 105, 3), 441); }
  @Test(timeout = 3000) public void test48() { assertEquals(sut.minDis(240, 327172, 13, 9158, 1407), 50011); }
  @Test(timeout = 3000) public void test49() { assertEquals(sut.minDis(253966, 127793, 81201, 178, 1103899), 1300767); }
  @Test(timeout = 3000) public void test50() { assertEquals(sut.minDis(4167355, 1314, 2784262, 586, 3), 1857); }
  @Test(timeout = 3000) public void test51() { assertEquals(sut.minDis(32, 432, 91, 3566, 22), 14286); }
  @Test(timeout = 3000) public void test52() { assertEquals(sut.minDis(280252, 818, 10007, 15045, 4086), 165117); }
  @Test(timeout = 3000) public void test53() { assertEquals(sut.minDis(4467, 519461, 197, 4575, 1), 9167); }
  @Test(timeout = 3000) public void test54() { assertEquals(sut.minDis(1878, 2411, 3436, 18604, 7), 18744); }
  @Test(timeout = 3000) public void test55() { assertEquals(sut.minDis(4623, 45, 236, 45708, 518), 55032); }
  @Test(timeout = 3000) public void test56() { assertEquals(sut.minDis(131, 365, 228765, 46809, 1844), 67093); }
  @Test(timeout = 3000) public void test57() { assertEquals(sut.minDis(58, 1729, 1, 1, 2), 8); }
  @Test(timeout = 3000) public void test58() { assertEquals(sut.minDis(1055623, 2, 7897, 75, 458), 8761); }
  @Test(timeout = 3000) public void test59() { assertEquals(sut.minDis(1778098, 2, 830, 3, 29712), 247203); }
  @Test(timeout = 3000) public void test60() { assertEquals(sut.minDis(19330, 471, 2450, 7188, 50), 64942); }
  @Test(timeout = 3000) public void test61() { assertEquals(sut.minDis(16, 362486, 23, 4, 15198), 60); }
  @Test(timeout = 3000) public void test62() { assertEquals(sut.minDis(241968, 329032, 28, 251679, 331), 1065634); }
  @Test(timeout = 3000) public void test63() { assertEquals(sut.minDis(69, 388745, 329392, 4, 19), 42); }
  @Test(timeout = 3000) public void test64() { assertEquals(sut.minDis(1315507, 830593, 481462, 259016, 548887), 6235063); }
  @Test(timeout = 3000) public void test65() { assertEquals(sut.minDis(661, 158, 25, 1032143, 2076289), 9301290); }
  @Test(timeout = 3000) public void test66() { assertEquals(sut.minDis(424261, 15560, 716682, 1, 64856), 65000); }
  @Test(timeout = 3000) public void test67() { assertEquals(sut.minDis(221113, 3284, 915, 4387, 806065), 1841397); }
  @Test(timeout = 3000) public void test68() { assertEquals(sut.minDis(495, 4926, 2548645, 279942, 3441), 2526360); }
  @Test(timeout = 3000) public void test69() { assertEquals(sut.minDis(5000000, 1, 2703, 565995, 16071), 403038819); }
  @Test(timeout = 3000) public void test70() { assertEquals(sut.minDis(21217, 387, 1861, 2564972, 86), 2590686); }
  @Test(timeout = 3000) public void test71() { assertEquals(sut.minDis(3203, 3127678, 27555, 27, 10), 198); }
  @Test(timeout = 3000) public void test72() { assertEquals(sut.minDis(744, 215061, 1480476, 1571129, 3), 4713405); }
  @Test(timeout = 3000) public void test73() { assertEquals(sut.minDis(88072, 43927, 115, 2322254, 54184), 241568600); }
  @Test(timeout = 3000) public void test74() { assertEquals(sut.minDis(2410252, 304, 22, 455, 12), 2588); }
  @Test(timeout = 3000) public void test75() { assertEquals(sut.minDis(3597470, 14, 2969, 768, 860689), 3423027); }
  @Test(timeout = 3000) public void test76() { assertEquals(sut.minDis(4515823, 741823, 968, 1257, 21), 5052); }
  @Test(timeout = 3000) public void test77() { assertEquals(sut.minDis(6906, 304, 724, 3, 751890), 20715); }
  @Test(timeout = 3000) public void test78() { assertEquals(sut.minDis(2032, 37843, 4286, 1362944, 14), 1363322); }
  @Test(timeout = 3000) public void test79() { assertEquals(sut.minDis(11801, 11301, 5, 1517308, 154475), 7950374); }
  @Test(timeout = 3000) public void test80() { assertEquals(sut.minDis(3855749, 834, 2534, 6, 23326), 48728); }
  @Test(timeout = 3000) public void test81() { assertEquals(sut.minDis(150, 220374, 516031, 143, 1655), 3800); }
  @Test(timeout = 3000) public void test82() { assertEquals(sut.minDis(100247, 293268, 6, 23601, 129150), 928962); }
  @Test(timeout = 3000) public void test83() { assertEquals(sut.minDis(13410, 12268, 868849, 372102, 355188), 2875332); }
  @Test(timeout = 3000) public void test84() { assertEquals(sut.minDis(1514, 2, 797481, 833300, 107), 54249); }
  @Test(timeout = 3000) public void test85() { assertEquals(sut.minDis(5000000, 88318, 1787, 42, 4166753), 4245587); }
  @Test(timeout = 3000) public void test86() { assertEquals(sut.minDis(68, 7898, 26026, 622794, 2081040), 7063392); }
  @Test(timeout = 3000) public void test87() { assertEquals(sut.minDis(6830, 734, 9428, 451, 1965), 12370); }
  @Test(timeout = 3000) public void test88() { assertEquals(sut.minDis(10831, 174, 2991, 549, 124), 3631); }
  @Test(timeout = 3000) public void test89() { assertEquals(sut.minDis(27, 1, 468, 96477, 31268), 834352); }
  @Test(timeout = 3000) public void test90() { assertEquals(sut.minDis(37, 28, 22517, 139, 7800), 5004); }
  @Test(timeout = 3000) public void test91() { assertEquals(sut.minDis(2515391, 138017, 248604, 258340, 346684), 5615212); }
  @Test(timeout = 3000) public void test92() { assertEquals(sut.minDis(756, 419, 127, 101546, 24752), 200554); }
  @Test(timeout = 3000) public void test93() { assertEquals(sut.minDis(20202, 193, 136, 23, 19161), 25808); }
  @Test(timeout = 3000) public void test94() { assertEquals(sut.minDis(23463, 1216, 336, 440, 21), 1489); }
  @Test(timeout = 3000) public void test95() { assertEquals(sut.minDis(87, 2, 631948, 554, 1403), 6943); }
  @Test(timeout = 3000) public void test96() { assertEquals(sut.minDis(121, 306, 712, 521632, 675278), 4848334); }
  @Test(timeout = 3000) public void test97() { assertEquals(sut.minDis(380, 194110, 851949, 488, 1), 2); }
  @Test(timeout = 3000) public void test98() { assertEquals(sut.minDis(1076, 11047, 505, 121, 1), 161); }
  @Test(timeout = 3000) public void test99() { assertEquals(sut.minDis(3692, 89006, 43, 576911, 104), 1731669); }
  @Test(timeout = 3000) public void test100() { assertEquals(sut.minDis(104842, 303, 747, 3, 753), 1731); }
  @Test(timeout = 3000) public void test101() { assertEquals(sut.minDis(15670, 43, 210439, 25859, 565), 65843); }
  @Test(timeout = 3000) public void test102() { assertEquals(sut.minDis(8813, 2384784, 943391, 484959, 28), 71484); }
  @Test(timeout = 3000) public void test103() { assertEquals(sut.minDis(94921, 119742, 22360, 461, 1710), 15272); }
  @Test(timeout = 3000) public void test104() { assertEquals(sut.minDis(224, 10494, 7, 188, 1), 1130); }
  @Test(timeout = 3000) public void test105() { assertEquals(sut.minDis(2203618, 1836, 210469, 96, 4), 324); }
  @Test(timeout = 3000) public void test106() { assertEquals(sut.minDis(2763, 893999, 2390, 4190875, 399), 4213219); }
  @Test(timeout = 3000) public void test107() { assertEquals(sut.minDis(46161, 3, 48023, 2555841, 105599), 8913246); }
  @Test(timeout = 3000) public void test108() { assertEquals(sut.minDis(918, 359, 102270, 42, 1337), 2639); }
  @Test(timeout = 3000) public void test109() { assertEquals(sut.minDis(4946117, 7, 249999, 442221, 453), 950580); }
  @Test(timeout = 3000) public void test110() { assertEquals(sut.minDis(4951434, 567183, 8579, 8, 502), 2368); }
  @Test(timeout = 3000) public void test111() { assertEquals(sut.minDis(4994877, 133466, 1899, 188, 112601), 261298); }
  @Test(timeout = 3000) public void test112() { assertEquals(sut.minDis(4957962, 136, 229157, 3448, 182447), 874901); }
  @Test(timeout = 3000) public void test113() { assertEquals(sut.minDis(4931276, 2, 1224, 3619, 98675), 1767950); }
  @Test(timeout = 3000) public void test114() { assertEquals(sut.minDis(4912726, 1524540, 1471, 39986, 13976), 395594); }
  @Test(timeout = 3000) public void test115() { assertEquals(sut.minDis(4988454, 756, 199646, 2212, 53228), 303604); }
  @Test(timeout = 3000) public void test116() { assertEquals(sut.minDis(4973759, 6227, 94494, 643758, 1482867), 22806822); }
  @Test(timeout = 3000) public void test117() { assertEquals(sut.minDis(4949789, 49357, 680737, 16881, 37), 43863); }
  @Test(timeout = 3000) public void test118() { assertEquals(sut.minDis(4909778, 499, 14181, 3, 2038033), 2068681); }
  @Test(timeout = 3000) public void test119() { assertEquals(sut.minDis(4992823, 1709164, 1, 108, 11206), 42474); }
  @Test(timeout = 3000) public void test120() { assertEquals(sut.minDis(4923157, 45788, 19, 27, 116963), 173366); }
  @Test(timeout = 3000) public void test121() { assertEquals(sut.minDis(4914166, 483, 1, 9292, 2132), 104788); }
  @Test(timeout = 3000) public void test122() { assertEquals(sut.minDis(4934635, 2, 63, 127, 124989), 1645410); }
  @Test(timeout = 3000) public void test123() { assertEquals(sut.minDis(4973872, 267380, 5, 26, 1146483), 1227265); }
  @Test(timeout = 3000) public void test124() { assertEquals(sut.minDis(4981533, 143, 5104, 1, 567), 1464); }
  @Test(timeout = 3000) public void test125() { assertEquals(sut.minDis(4971808, 756, 682837, 202679, 608911), 7912347); }
  @Test(timeout = 3000) public void test126() { assertEquals(sut.minDis(4973788, 55228, 144751, 14, 13987), 31474); }
  @Test(timeout = 3000) public void test127() { assertEquals(sut.minDis(4939690, 518654, 670723, 4, 31253), 33881); }
  @Test(timeout = 3000) public void test128() { assertEquals(sut.minDis(4902343, 9276, 1013, 80495, 218), 260398); }
  @Test(timeout = 3000) public void test129() { assertEquals(sut.minDis(4943399, 61, 1, 4024309, 25453), 12884688); }
  @Test(timeout = 3000) public void test130() { assertEquals(sut.minDis(4983628, 137306, 180692, 3301146, 3), 26409297); }
  @Test(timeout = 3000) public void test131() { assertEquals(sut.minDis(4971074, 57914, 4, 128099, 225958), 4113446); }
  @Test(timeout = 3000) public void test132() { assertEquals(sut.minDis(4975820, 933, 2956438, 1240351, 12), 1254139); }
  @Test(timeout = 3000) public void test133() { assertEquals(sut.minDis(4953094, 1761, 9, 971114, 2253), 2805127); }
  @Test(timeout = 3000) public void test134() { assertEquals(sut.minDis(5000000, 1234567, 1234567, 1234567, 192811), 12112567); }
  @Test(timeout = 3000) public void test135() { assertEquals(sut.minDis(5000000, 4343243, 2343435, 4477777, 4777777), 88377763); }
  @Test(timeout = 3000) public void test136() { assertEquals(sut.minDis(5000000, 5000000, 5000000, 5000000, 5000000), 24999995000000L); }
  @Test(timeout = 3000) public void test137() { assertEquals(sut.minDis(4999888, 4999887, 4999886, 4999885, 4999), 5004884); }
  @Test(timeout = 3000) public void test138() { assertEquals(sut.minDis(5000000, 1, 5, 1, 5000000), 4999999); }
  @Test(timeout = 3000) public void test139() { assertEquals(sut.minDis(5000000, 4399978, 444, 600000, 300000), 10800000); }
  @Test(timeout = 3000) public void test140() { assertEquals(sut.minDis(4491416, 520323, 2814059, 4230437, 2337229), 55766599); }
  @Test(timeout = 3000) public void test141() { assertEquals(sut.minDis(5000000, 139, 29, 40000, 1110000), 6670000); }
  @Test(timeout = 3000) public void test142() { assertEquals(sut.minDis(4987987, 4989987, 2, 4987989, 1987987), 70663646); }
  @Test(timeout = 3000) public void test143() { assertEquals(sut.minDis(4999999, 3389348, 383347, 4383499, 999679), 47294253); }
  @Test(timeout = 3000) public void test144() { assertEquals(sut.minDis(3052872, 2403684, 978913, 235809, 4893111), 34428411); }
  @Test(timeout = 3000) public void test145() { assertEquals(sut.minDis(5, 1, 3, 10000, 1), 3); }
  @Test(timeout = 3000) public void test146() { assertEquals(sut.minDis(3668033, 4039245, 279685, 921170, 972533), 21036185); }
  @Test(timeout = 3000) public void test147() { assertEquals(sut.minDis(5000000, 1, 2500000, 1, 2500000), 4999999); }
  @Test(timeout = 3000) public void test148() { assertEquals(sut.minDis(2810602, 1320191, 4335997, 4976241, 1524438), 62273571); }
  @Test(timeout = 3000) public void test149() { assertEquals(sut.minDis(4, 2, 0, 2, 1), 5); }
  @Test(timeout = 3000) public void test150() { assertEquals(sut.minDis(1000000, 1000000, 1000001, 5000000, 1), 4999990000001L); }
  @Test(timeout = 3000) public void test151() { assertEquals(sut.minDis(5, 1, 2, 1, 10), 4); }
  @Test(timeout = 3000) public void test152() { assertEquals(sut.minDis(5000000, 4000001, 4987654, 4000001, 4987654), 503999999); }
  @Test(timeout = 3000) public void test153() { assertEquals(sut.minDis(5000000, 1, 0, 5000000, 5000000), 24999995000000L); }

}
