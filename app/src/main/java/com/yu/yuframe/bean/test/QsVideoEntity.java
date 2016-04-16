package com.yu.yuframe.bean.test;

import java.util.List;

/**
 * Created by Yu on 2016/4/16.
 * Email:zhaoshiyu900310@163.com
 */
public class QsVideoEntity {


    /**
     * count : 30
     * err : 0
     * items : [{"high_url":"http://qiubai-video.qiushibaike.com/7IKEY4YA76TW0SSW.mp4","format":"video","image":null,
     * "published_at":1459219501,"tag":"null","user":{"avatar_updated_at":1459245887,"uid":29099696,
     * "last_visited_at":1435097626,"created_at":1435097626,"state":"active","last_device":"android_7.1.1",
     * "role":"n","login":"大笑浆糊o","id":29099696,"icon":"20160329100446.jpg"},"image_size":null,"id":115735707,
     * "votes":{"down":-256,"up":4600},"created_at":1459216826,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/7IKEY4YA76TW0SSW.jpg","content":"对于妹纸来说又一个技能，胸器！！！！","state":"publish","comments_count":296,
     * "low_url":"http://qiubai-video.qiushibaike.com/7IKEY4YA76TW0SSW_3g.mp4","allow_comment":true,
     * "share_count":2617,"type":"hot","loop":391497},{"high_url":"http://qiubai-video.qiushibaike
     * .com/HH8T0FYKW0ZX586T.mp4","format":"video","image":null,"published_at":1459207201,"tag":"null",
     * "user":{"avatar_updated_at":1458946487,"uid":31480340,"last_visited_at":1458946487,"created_at":1458946487,
     * "state":"active","last_device":"android_9.1.0","role":"n","login":"无馬，電景彡","id":31480340,
     * "icon":"20160325225447.jpg"},"image_size":null,"id":115730679,"votes":{"down":-178,"up":3236},
     * "created_at":1459172270,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/HH8T0FYKW0ZX586T
     * .jpg","content":"这技术没谁了","state":"publish","comments_count":123,"low_url":"http://qiubai-video.qiushibaike
     * .com/HH8T0FYKW0ZX586T_3g.mp4","allow_comment":true,"share_count":350,"type":"hot","loop":300278},
     * {"high_url":"http://qiubai-video.qiushibaike.com/2V6Y1BRPM17VCO5V.mp4","format":"video","image":null,
     * "published_at":1459209301,"tag":"null","user":{"avatar_updated_at":1458001269,"uid":14917758,
     * "last_visited_at":1395479284,"created_at":1395479284,"state":"active","last_device":"android_2.8","role":"n",
     * "login":"眼前春色","id":14917758,"icon":"20160315002108.jpg"},"image_size":null,"id":115730774,
     * "votes":{"down":-84,"up":3029},"created_at":1459172677,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/2V6Y1BRPM17VCO5V.jpg","content":"快让开，火车来了","state":"publish","comments_count":61,
     * "low_url":"http://qiubai-video.qiushibaike.com/2V6Y1BRPM17VCO5V_3g.mp4","allow_comment":true,
     * "share_count":394,"type":"hot","loop":128110},{"high_url":"http://qiubai-video.qiushibaike
     * .com/5EJAMEXALEWZS2QL.mp4","format":"video","image":null,"published_at":1459217702,"tag":"null",
     * "user":{"avatar_updated_at":1444391244,"uid":16958337,"last_visited_at":1402783137,"created_at":1402783137,
     * "state":"active","last_device":"android_3.0.0","role":"n","login":"真爱生命远离糗百","id":16958337,
     * "icon":"20151009114724.jpg"},"image_size":null,"id":115733884,"votes":{"down":-139,"up":2894},
     * "created_at":1459203585,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/5EJAMEXALEWZS2QL
     * .jpg","content":"逗逼损友！","state":"publish","comments_count":56,"low_url":"http://qiubai-video.qiushibaike
     * .com/5EJAMEXALEWZS2QL_3g.mp4","allow_comment":true,"share_count":731,"type":"hot","loop":212680},
     * {"high_url":"http://qiubai-video.qiushibaike.com/W1AK7PI2RCAQV1WZ.mp4","format":"video","image":null,
     * "published_at":1459224901,"tag":"null","user":{"avatar_updated_at":0,"uid":12752846,
     * "last_visited_at":1385796359,"created_at":1385796359,"state":"active","last_device":"android_2.6.3",
     * "role":"n","login":"孤独的守望着小鸡","id":12752846,"icon":"20150905122034.jpg"},"image_size":null,"id":115736053,
     * "votes":{"down":-76,"up":1131},"created_at":1459218714,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/W1AK7PI2RCAQV1WZ.jpg","content":"这个能过不！","state":"publish","comments_count":44,
     * "low_url":"http://qiubai-video.qiushibaike.com/W1AK7PI2RCAQV1WZ_3g.mp4","allow_comment":true,
     * "share_count":152,"type":"hot","loop":35175},{"high_url":"http://qiubai-video.qiushibaike.com/1B4P8FURFC1HKY2M
     * .mp4","format":"video","image":null,"published_at":1459219801,"tag":"null",
     * "user":{"avatar_updated_at":1459245887,"uid":29099696,"last_visited_at":1435097626,"created_at":1435097626,
     * "state":"active","last_device":"android_7.1.1","role":"n","login":"大笑浆糊o","id":29099696,"icon":"20160329100446
     * .jpg"},"image_size":null,"id":115735787,"votes":{"down":-54,"up":1290},"created_at":1459217243,
     * "pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/1B4P8FURFC1HKY2M.jpg","content":"未来的影帝啊",
     * "state":"publish","comments_count":25,"low_url":"http://qiubai-video.qiushibaike.com/1B4P8FURFC1HKY2M_3g.mp4",
     * "allow_comment":true,"share_count":65,"type":"hot","loop":96636},{"high_url":"http://qiubai-video.qiushibaike
     * .com/ZZMG8X6NV620L6UP.mp4","format":"video","image":null,"published_at":1459229101,"tag":"null",
     * "user":{"avatar_updated_at":1457186369,"uid":31338153,"last_visited_at":1457186368,"created_at":1457186368,
     * "state":"active","last_device":"ios_9.2.7","role":"n","login":"☆心/xs淡☆","id":31338153,"icon":"20160305135928
     * .jpg"},"image_size":null,"id":115737656,"votes":{"down":-55,"up":315},"created_at":1459226925,"pic_size":[480,
     * 480],"pic_url":"http://qiubai-video.qiushibaike.com/ZZMG8X6NV620L6UP.jpg","content":"想当年哥也是一个",
     * "state":"publish","comments_count":14,"low_url":"http://qiubai-video.qiushibaike.com/ZZMG8X6NV620L6UP_3g.mp4",
     * "allow_comment":true,"share_count":69,"loop":30373},{"high_url":"http://qiubai-video.qiushibaike
     * .com/BV4FQ7AM8CEWF13A.mp4","format":"video","image":null,"published_at":1459227901,"tag":"null",
     * "user":{"avatar_updated_at":1457429794,"uid":9888189,"last_visited_at":1373269865,"created_at":1373269865,
     * "state":"active","last_device":"android_2.5.2","role":"n","login":"慢羊羊卡哇伊","id":9888189,"icon":"20160308093633
     * .jpg"},"image_size":null,"id":115737128,"votes":{"down":-44,"up":506},"created_at":1459224471,"pic_size":[480,
     * 480],"pic_url":"http://qiubai-video.qiushibaike.com/BV4FQ7AM8CEWF13A.jpg",
     * "content":"糖宝！不进进长留山\u2026\u2026气人不你说","state":"publish","comments_count":18,"low_url":"http://qiubai-video
     * .qiushibaike.com/BV4FQ7AM8CEWF13A_3g.mp4","allow_comment":true,"share_count":32,"loop":50075},
     * {"high_url":"http://qiubai-video.qiushibaike.com/LXD9MTL2NGL77CD6.mp4","format":"video","image":null,
     * "published_at":1459220102,"tag":"null","user":{"avatar_updated_at":1398521289,"uid":15875555,
     * "last_visited_at":1398520911,"created_at":1398520911,"state":"bonding","last_device":"android_2.8","role":"n",
     * "login":"沉默者沉默着","id":15875555,"icon":"20140426220809.jpg"},"image_size":null,"id":115735318,
     * "votes":{"down":-44,"up":1096},"created_at":1459214844,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/LXD9MTL2NGL77CD6.jpg","content":"Why？？？","state":"publish","comments_count":39,
     * "low_url":"http://qiubai-video.qiushibaike.com/LXD9MTL2NGL77CD6_3g.mp4","allow_comment":true,"share_count":52,
     * "type":"hot","loop":66626},{"high_url":"http://qiubai-video.qiushibaike.com/QDFIA8E8L8LMSYYL.mp4",
     * "format":"video","image":null,"published_at":1459228502,"tag":"null","user":{"avatar_updated_at":1459253154,
     * "uid":31500929,"last_visited_at":1459253153,"created_at":1459253153,"state":"active","last_device":"android_9
     * .3.1","role":"n","login":"轮滑小军","id":31500929,"icon":"20160329120553.jpg"},"image_size":null,"id":115737425,
     * "votes":{"down":-32,"up":383},"created_at":1459225928,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/QDFIA8E8L8LMSYYL.jpg","content":"轮滑摇，666","state":"publish","comments_count":28,
     * "low_url":"http://qiubai-video.qiushibaike.com/QDFIA8E8L8LMSYYL_3g.mp4","allow_comment":true,"share_count":21,
     * "loop":26591},{"high_url":"http://qiubai-video.qiushibaike.com/8HCZD04ZEV3RE39I.mp4","format":"video",
     * "image":null,"published_at":1459218301,"tag":"null","user":{"avatar_updated_at":1398521289,"uid":15875555,
     * "last_visited_at":1398520911,"created_at":1398520911,"state":"bonding","last_device":"android_2.8","role":"n",
     * "login":"沉默者沉默着","id":15875555,"icon":"20140426220809.jpg"},"image_size":null,"id":115735195,
     * "votes":{"down":-89,"up":1806},"created_at":1459214162,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/8HCZD04ZEV3RE39I.jpg","content":"作死","state":"publish","comments_count":59,
     * "low_url":"http://qiubai-video.qiushibaike.com/8HCZD04ZEV3RE39I_3g.mp4","allow_comment":true,
     * "share_count":229,"type":"hot","loop":153127},{"high_url":"http://qiubai-video.qiushibaike
     * .com/TTYWX2JGTSOQIQGD.mp4","format":"video","image":null,"published_at":1459216802,"tag":"null",
     * "user":{"avatar_updated_at":1434146991,"uid":28802284,"last_visited_at":1433425212,"created_at":1433425212,
     * "state":"active","last_device":"ios_6.8.4","role":"n","login":"1个孤单的魂","id":28802284,"icon":"20150613060950
     * .jpg"},"image_size":null,"id":115732736,"votes":{"down":-64,"up":1313},"created_at":1459181830,
     * "pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/TTYWX2JGTSOQIQGD.jpg",
     * "content":"这也拉得太妖娆了吧","state":"publish","comments_count":37,"low_url":"http://qiubai-video.qiushibaike
     * .com/TTYWX2JGTSOQIQGD_3g.mp4","allow_comment":true,"share_count":130,"type":"hot","loop":74401},
     * {"high_url":"http://qiubai-video.qiushibaike.com/QDISKY8FUWM9YRN8.mp4","format":"video","image":null,
     * "published_at":1459218602,"tag":"null","user":{"avatar_updated_at":1378696302,"uid":10034205,
     * "last_visited_at":1373899466,"created_at":1373899466,"state":"active","last_device":"android_2.3.1",
     * "role":"n","login":"小母牛～来月经","id":10034205,"icon":"20130909111141.jpg"},"image_size":null,"id":115734865,
     * "votes":{"down":-49,"up":1285},"created_at":1459211935,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/QDISKY8FUWM9YRN8.jpg","content":"昨天临沂的风真心带劲啊！","state":"publish","comments_count":74,
     * "low_url":"http://qiubai-video.qiushibaike.com/QDISKY8FUWM9YRN8_3g.mp4","allow_comment":true,"share_count":49,
     * "type":"hot","loop":72397},{"high_url":"http://qiubai-video.qiushibaike.com/BTLZ7HCWWSCQIHVU.mp4",
     * "format":"video","image":null,"published_at":1459219201,"tag":"null","user":{"avatar_updated_at":1354722957,
     * "uid":2952882,"last_visited_at":1344444230,"created_at":1344444230,"state":"bonding","last_device":"android_2
     * .0.4","role":"n","login":"拒绝日货","id":2952882,"icon":"20121205235551.JPG"},"image_size":null,"id":115733915,
     * "votes":{"down":-68,"up":1157},"created_at":1459203940,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/BTLZ7HCWWSCQIHVU.jpg","content":"她有什么优点？","state":"publish","comments_count":30,
     * "low_url":"http://qiubai-video.qiushibaike.com/BTLZ7HCWWSCQIHVU_3g.mp4","allow_comment":true,"share_count":90,
     * "type":"hot","loop":111069},{"high_url":"http://qiubai-video.qiushibaike.com/RW75P4XDFGP2I39G.mp4",
     * "format":"video","image":null,"published_at":1459215601,"tag":"null","user":{"avatar_updated_at":0,
     * "uid":12752846,"last_visited_at":1385796359,"created_at":1385796359,"state":"active","last_device":"android_2
     * .6.3","role":"n","login":"孤独的守望着小鸡","id":12752846,"icon":"20150905122034.jpg"},"image_size":null,
     * "id":115733786,"votes":{"down":-64,"up":1955},"created_at":1459202204,"pic_size":[480,480],
     * "pic_url":"http://qiubai-video.qiushibaike.com/RW75P4XDFGP2I39G.jpg","content":"作为汪星人丢脸丢到家了，啃生的大白菜，弄熟再吃不行吗？",
     * "state":"publish","comments_count":109,"low_url":"http://qiubai-video.qiushibaike.com/RW75P4XDFGP2I39G_3g
     * .mp4","allow_comment":true,"share_count":139,"type":"hot","loop":55435},{"high_url":"http://qiubai-video
     * .qiushibaike.com/WK20XL6ERI3UUTKL.mp4","format":"video","image":null,"published_at":1459216501,"tag":"null",
     * "user":{"avatar_updated_at":0,"uid":30398048,"last_visited_at":1444048248,"created_at":1444048248,
     * "state":"active","last_device":"android_8.1.2","role":"n","login":"别皱眉°","id":30398048,"icon":"20151005123048
     * .jpg"},"image_size":null,"id":115734878,"votes":{"down":-139,"up":1639},"created_at":1459212026,
     * "pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/WK20XL6ERI3UUTKL.jpg","content":"大哥
     * 你还是回来修手机吧 来看看我的肾6为什么在开机的时候有个小机器人","state":"publish","comments_count":91,"low_url":"http://qiubai-video
     * .qiushibaike.com/WK20XL6ERI3UUTKL_3g.mp4","allow_comment":true,"share_count":188,"type":"hot","loop":115861},
     * {"high_url":"http://qiubai-video.qiushibaike.com/CIU2BKK9DVGYWO6B.mp4","format":"video","image":null,
     * "published_at":1459215002,"tag":"null","user":{"avatar_updated_at":1458945237,"uid":31480189,
     * "last_visited_at":1458945237,"created_at":1458945237,"state":"active","last_device":"android_9.2.0",
     * "role":"n","login":"云pan.肆石","id":31480189,"icon":"20160325223357.jpg"},"image_size":null,"id":115730511,
     * "votes":{"down":-40,"up":781},"created_at":1459171510,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/CIU2BKK9DVGYWO6B.jpg","content":"哈哈哈哈哈哈","state":"publish","comments_count":22,
     * "low_url":"http://qiubai-video.qiushibaike.com/CIU2BKK9DVGYWO6B_3g.mp4","allow_comment":true,"share_count":40,
     * "loop":49586},{"high_url":"http://qiubai-video.qiushibaike.com/9LGMZHKE3B9ABUXD.mp4","format":"video",
     * "image":null,"published_at":1459215301,"tag":"null","user":{"avatar_updated_at":1451459064,"uid":30872147,
     * "last_visited_at":1451459063,"created_at":1451459063,"state":"active","last_device":"android_9.0.0",
     * "role":"n","login":"我是雷楼某","id":30872147,"icon":"20151230070423.jpg"},"image_size":null,"id":115733450,
     * "votes":{"down":-25,"up":619},"created_at":1459190650,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/9LGMZHKE3B9ABUXD.jpg","content":"法式湿吻，作为单身狗我最恨秀恩爱的！拍完视频十分钟，此狗卒，享年两岁半。","state":"publish",
     * "comments_count":16,"low_url":"http://qiubai-video.qiushibaike.com/9LGMZHKE3B9ABUXD_3g.mp4",
     * "allow_comment":true,"share_count":13,"loop":53449},{"high_url":"http://qiubai-video.qiushibaike
     * .com/771MBKWJCLGDS40K.mp4","format":"video","image":null,"published_at":1459210802,"tag":"null",
     * "user":{"avatar_updated_at":1458945237,"uid":31480189,"last_visited_at":1458945237,"created_at":1458945237,
     * "state":"active","last_device":"android_9.2.0","role":"n","login":"云pan.肆石","id":31480189,
     * "icon":"20160325223357.jpg"},"image_size":null,"id":115730518,"votes":{"down":-29,"up":1100},
     * "created_at":1459171535,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/771MBKWJCLGDS40K
     * .jpg","content":"玩的还不错吧","state":"publish","comments_count":20,"low_url":"http://qiubai-video.qiushibaike
     * .com/771MBKWJCLGDS40K_3g.mp4","allow_comment":true,"share_count":22,"type":"hot","loop":54257},
     * {"high_url":"http://qiubai-video.qiushibaike.com/250DVFGVMOQYI8C0.mp4","format":"video","image":null,
     * "published_at":1459218002,"tag":"null","user":{"avatar_updated_at":1457436158,"uid":31353286,
     * "last_visited_at":1457350926,"created_at":1457350926,"state":"active","last_device":"android_9.2.0",
     * "role":"n","login":"瘦猪肉炖粉条子","id":31353286,"icon":"nopic.jpg"},"image_size":null,"id":115733130,
     * "votes":{"down":-193,"up":2082},"created_at":1459185191,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/250DVFGVMOQYI8C0.jpg","content":"自己看吧啊","state":"publish","comments_count":110,
     * "low_url":"http://qiubai-video.qiushibaike.com/250DVFGVMOQYI8C0_3g.mp4","allow_comment":true,
     * "share_count":659,"type":"hot","loop":151443},{"high_url":"http://qiubai-video.qiushibaike
     * .com/65762Z559P26HN45.mp4","format":"video","image":null,"published_at":1459213801,"tag":"null",
     * "user":{"avatar_updated_at":1458945237,"uid":31480189,"last_visited_at":1458945237,"created_at":1458945237,
     * "state":"active","last_device":"android_9.2.0","role":"n","login":"云pan.肆石","id":31480189,
     * "icon":"20160325223357.jpg"},"image_size":null,"id":115730338,"votes":{"down":-143,"up":2305},
     * "created_at":1459170797,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/65762Z559P26HN45
     * .jpg","content":"卖草莓的调包了！看到没","state":"publish","comments_count":96,"low_url":"http://qiubai-video.qiushibaike
     * .com/65762Z559P26HN45_3g.mp4","allow_comment":true,"share_count":158,"type":"hot","loop":209359},
     * {"high_url":"http://qiubai-video.qiushibaike.com/2KU0VI2MCYYJODK1.mp4","format":"video","image":null,
     * "published_at":1459209001,"tag":"null","user":{"avatar_updated_at":1458950360,"uid":30363842,
     * "last_visited_at":1443528025,"created_at":1443528025,"state":"active","last_device":"android_7.3.0",
     * "role":"n","login":"伤痛让我情何以堪","id":30363842,"icon":"20160325235920.jpg"},"image_size":null,"id":115729060,
     * "votes":{"down":-66,"up":2541},"created_at":1459165098,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/2KU0VI2MCYYJODK1.jpg","content":"感觉很厉害的样子","state":"publish","comments_count":87,
     * "low_url":"http://qiubai-video.qiushibaike.com/2KU0VI2MCYYJODK1_3g.mp4","allow_comment":true,"share_count":40,
     * "type":"hot","loop":79822},{"high_url":"http://qiubai-video.qiushibaike.com/TS8PIP8X5572JY3I.mp4",
     * "format":"video","image":null,"published_at":1459225501,"tag":"null","user":{"avatar_updated_at":1403529157,
     * "uid":13297027,"last_visited_at":1389198519,"created_at":1389198519,"state":"active","last_device":"ios_2.6
     * .4","role":"n","login":"漂泊广州异乡人","id":13297027,"icon":"20140623211235.jpg"},"image_size":null,"id":115736236,
     * "votes":{"down":-49,"up":375},"created_at":1459219763,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/TS8PIP8X5572JY3I.jpg","content":"标准不知几个字！！！","state":"publish","comments_count":22,
     * "low_url":"http://qiubai-video.qiushibaike.com/TS8PIP8X5572JY3I_3g.mp4","allow_comment":true,"share_count":25,
     * "loop":39413},{"high_url":"http://qiubai-video.qiushibaike.com/0WC24QPQQUCYYVVB.mp4","format":"video",
     * "image":null,"published_at":1459211101,"tag":"null","user":{"avatar_updated_at":1445847800,"uid":28636634,
     * "last_visited_at":1432616190,"created_at":1432616190,"state":"active","last_device":"android_6.7.1",
     * "role":"n","login":"⑤大爷","id":28636634,"icon":"20151026082319.jpg"},"image_size":null,"id":115730605,
     * "votes":{"down":-37,"up":950},"created_at":1459171957,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/0WC24QPQQUCYYVVB.jpg","content":"这老大爷太有才了","state":"publish","comments_count":9,
     * "low_url":"http://qiubai-video.qiushibaike.com/0WC24QPQQUCYYVVB_3g.mp4","allow_comment":true,"share_count":27,
     * "loop":43980},{"high_url":"http://qiubai-video.qiushibaike.com/H9HK3XV1UZFQIK7R.mp4","format":"video",
     * "image":null,"published_at":1459210502,"tag":"null","user":{"avatar_updated_at":1406653689,"uid":12049563,
     * "last_visited_at":1382528033,"created_at":1382528033,"state":"active","last_device":"android_2.6.2",
     * "role":"n","login":"花若愚","id":12049563,"icon":"20140730010810.jpg"},"image_size":null,"id":115731827,
     * "votes":{"down":-56,"up":1200},"created_at":1459177172,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/H9HK3XV1UZFQIK7R.jpg","content":"好风骚的男","state":"publish","comments_count":33,
     * "low_url":"http://qiubai-video.qiushibaike.com/H9HK3XV1UZFQIK7R_3g.mp4","allow_comment":true,"share_count":49,
     * "type":"hot","loop":51398},{"high_url":"http://qiubai-video.qiushibaike.com/9XBGYX8M4RINUQ1L.mp4",
     * "format":"video","image":null,"published_at":1459228802,"tag":"null","user":{"avatar_updated_at":1457801456,
     * "uid":29595334,"last_visited_at":1437957659,"created_at":1437957659,"state":"active","last_device":"ios_6.9
     * .4","role":"n","login":"喜欢的加我","id":29595334,"icon":"nopic.jpg"},"image_size":null,"id":115737377,
     * "votes":{"down":-49,"up":254},"created_at":1459225709,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/9XBGYX8M4RINUQ1L.jpg","content":"这个绝对第一次玩","state":"publish","comments_count":26,
     * "low_url":"http://qiubai-video.qiushibaike.com/9XBGYX8M4RINUQ1L_3g.mp4","allow_comment":true,"share_count":29,
     * "loop":46754},{"high_url":"http://qiubai-video.qiushibaike.com/SE736AEOELVC5HAI.mp4","format":"video",
     * "image":null,"published_at":1459214702,"tag":"null","user":{"avatar_updated_at":1458980228,"uid":31481887,
     * "last_visited_at":1458980227,"created_at":1458980227,"state":"active","last_device":"ios_9.3.1","role":"n",
     * "login":"媛宝的DB套套","id":31481887,"icon":"20160326081707.jpg"},"image_size":null,"id":115732236,
     * "votes":{"down":-27,"up":525},"created_at":1459179080,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/SE736AEOELVC5HAI.jpg","content":"第一次带俩小只溜公园.小粗短的腿上台阶都费力哈哈走一走就要趴下歇会.","state":"publish",
     * "comments_count":37,"low_url":"http://qiubai-video.qiushibaike.com/SE736AEOELVC5HAI_3g.mp4",
     * "allow_comment":true,"share_count":9,"loop":39381},{"high_url":"http://qiubai-video.qiushibaike
     * .com/OOJ9CXF620QD896P.mp4","format":"video","image":null,"published_at":1459206301,"tag":"null",
     * "user":{"avatar_updated_at":1403701805,"uid":15513833,"last_visited_at":1397229233,"created_at":1397229233,
     * "state":"active","last_device":"android_2.8.2","role":"n","login":"从小爱玩枪哟","id":15513833,
     * "icon":"20140625211004.jpg"},"image_size":null,"id":115731282,"votes":{"down":-27,"up":645},
     * "created_at":1459174822,"pic_size":[480,480],"pic_url":"http://qiubai-video.qiushibaike.com/OOJ9CXF620QD896P
     * .jpg","content":"飞舟冲浪","state":"publish","comments_count":36,"low_url":"http://qiubai-video.qiushibaike
     * .com/OOJ9CXF620QD896P_3g.mp4","allow_comment":true,"share_count":13,"loop":80312},
     * {"high_url":"http://qiubai-video.qiushibaike.com/2HUA9XMGLUMJAJ8I.mp4","format":"video","image":null,
     * "published_at":1459212302,"tag":"null","user":{"avatar_updated_at":1458946487,"uid":31480340,
     * "last_visited_at":1458946487,"created_at":1458946487,"state":"active","last_device":"android_9.1.0",
     * "role":"n","login":"无馬，電景彡","id":31480340,"icon":"20160325225447.jpg"},"image_size":null,"id":115730690,
     * "votes":{"down":-59,"up":932},"created_at":1459172310,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/2HUA9XMGLUMJAJ8I.jpg","content":"高手在民间","state":"publish","comments_count":28,
     * "low_url":"http://qiubai-video.qiushibaike.com/2HUA9XMGLUMJAJ8I_3g.mp4","allow_comment":true,"share_count":26,
     * "loop":50162},{"high_url":"http://qiubai-video.qiushibaike.com/GFRKR4AU9UDFJRL5.mp4","format":"video",
     * "image":null,"published_at":1459209601,"tag":"null","user":{"avatar_updated_at":1458079994,"uid":31413363,
     * "last_visited_at":1458079994,"created_at":1458079994,"state":"active","last_device":"android_9.2.0",
     * "role":"n","login":"A2墨菲签设","id":31413363,"icon":"20160315221314.jpg"},"image_size":null,"id":115732040,
     * "votes":{"down":-106,"up":918},"created_at":1459178150,"pic_size":[480,480],"pic_url":"http://qiubai-video
     * .qiushibaike.com/GFRKR4AU9UDFJRL5.jpg","content":"张辉糗友，标准艺术签，希望你喜欢。","state":"publish","comments_count":152,
     * "low_url":"http://qiubai-video.qiushibaike.com/GFRKR4AU9UDFJRL5_3g.mp4","allow_comment":true,
     * "share_count":115,"loop":40020}]
     * total : 1000
     * page : 1
     * refresh : 1000
     */

    private int count;
    private int err;
    private int total;
    private int page;
    private int refresh;
    /**
     * high_url : http://qiubai-video.qiushibaike.com/7IKEY4YA76TW0SSW.mp4
     * format : video
     * image : null
     * published_at : 1459219501
     * tag : null
     * user : {"avatar_updated_at":1459245887,"uid":29099696,"last_visited_at":1435097626,"created_at":1435097626,
     * "state":"active","last_device":"android_7.1.1","role":"n","login":"大笑浆糊o","id":29099696,"icon":"20160329100446
     * .jpg"}
     * image_size : null
     * id : 115735707
     * votes : {"down":-256,"up":4600}
     * created_at : 1459216826
     * pic_size : [480,480]
     * pic_url : http://qiubai-video.qiushibaike.com/7IKEY4YA76TW0SSW.jpg
     * content : 对于妹纸来说又一个技能，胸器！！！！
     * state : publish
     * comments_count : 296
     * low_url : http://qiubai-video.qiushibaike.com/7IKEY4YA76TW0SSW_3g.mp4
     * allow_comment : true
     * share_count : 2617
     * type : hot
     * loop : 391497
     */

    private List<ItemsEntity> items;

    public void setCount(int count) {
        this.count = count;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setRefresh(int refresh) {
        this.refresh = refresh;
    }

    public void setItems(List<ItemsEntity> items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public int getErr() {
        return err;
    }

    public int getTotal() {
        return total;
    }

    public int getPage() {
        return page;
    }

    public int getRefresh() {
        return refresh;
    }

    public List<ItemsEntity> getItems() {
        return items;
    }

    public static class ItemsEntity {
        private String high_url;
        private String format;
        private Object image;
        private int published_at;
        private String tag;
        /**
         * avatar_updated_at : 1459245887
         * uid : 29099696
         * last_visited_at : 1435097626
         * created_at : 1435097626
         * state : active
         * last_device : android_7.1.1
         * role : n
         * login : 大笑浆糊o
         * id : 29099696
         * icon : 20160329100446.jpg
         */

        private UserEntity user;
        private Object image_size;
        private int id;
        /**
         * down : -256
         * up : 4600
         */

        private VotesEntity votes;
        private int created_at;
        private String pic_url;
        private String content;
        private String state;
        private int comments_count;
        private String low_url;
        private boolean allow_comment;
        private int share_count;
        private String type;
        private int loop;
        private List<Integer> pic_size;

        public void setHigh_url(String high_url) {
            this.high_url = high_url;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public void setImage(Object image) {
            this.image = image;
        }

        public void setPublished_at(int published_at) {
            this.published_at = published_at;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public void setImage_size(Object image_size) {
            this.image_size = image_size;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setVotes(VotesEntity votes) {
            this.votes = votes;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public void setLow_url(String low_url) {
            this.low_url = low_url;
        }

        public void setAllow_comment(boolean allow_comment) {
            this.allow_comment = allow_comment;
        }

        public void setShare_count(int share_count) {
            this.share_count = share_count;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setLoop(int loop) {
            this.loop = loop;
        }

        public void setPic_size(List<Integer> pic_size) {
            this.pic_size = pic_size;
        }

        public String getHigh_url() {
            return high_url;
        }

        public String getFormat() {
            return format;
        }

        public Object getImage() {
            return image;
        }

        public int getPublished_at() {
            return published_at;
        }

        public String getTag() {
            return tag;
        }

        public UserEntity getUser() {
            return user;
        }

        public Object getImage_size() {
            return image_size;
        }

        public int getId() {
            return id;
        }

        public VotesEntity getVotes() {
            return votes;
        }

        public int getCreated_at() {
            return created_at;
        }

        public String getPic_url() {
            return pic_url;
        }

        public String getContent() {
            return content;
        }

        public String getState() {
            return state;
        }

        public int getComments_count() {
            return comments_count;
        }

        public String getLow_url() {
            return low_url;
        }

        public boolean isAllow_comment() {
            return allow_comment;
        }

        public int getShare_count() {
            return share_count;
        }

        public String getType() {
            return type;
        }

        public int getLoop() {
            return loop;
        }

        public List<Integer> getPic_size() {
            return pic_size;
        }

        public static class UserEntity {
            private int avatar_updated_at;
            private int uid;
            private int last_visited_at;
            private int created_at;
            private String state;
            private String last_device;
            private String role;
            private String login;
            private int id;
            private String icon;

            public void setAvatar_updated_at(int avatar_updated_at) {
                this.avatar_updated_at = avatar_updated_at;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public void setLast_visited_at(int last_visited_at) {
                this.last_visited_at = last_visited_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public void setState(String state) {
                this.state = state;
            }

            public void setLast_device(String last_device) {
                this.last_device = last_device;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public void setLogin(String login) {
                this.login = login;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public int getAvatar_updated_at() {
                return avatar_updated_at;
            }

            public int getUid() {
                return uid;
            }

            public int getLast_visited_at() {
                return last_visited_at;
            }

            public int getCreated_at() {
                return created_at;
            }

            public String getState() {
                return state;
            }

            public String getLast_device() {
                return last_device;
            }

            public String getRole() {
                return role;
            }

            public String getLogin() {
                return login;
            }

            public int getId() {
                return id;
            }

            public String getIcon() {
                return icon;
            }
        }

        public static class VotesEntity {
            private int down;
            private int up;

            public void setDown(int down) {
                this.down = down;
            }

            public void setUp(int up) {
                this.up = up;
            }

            public int getDown() {
                return down;
            }

            public int getUp() {
                return up;
            }
        }
    }
}
