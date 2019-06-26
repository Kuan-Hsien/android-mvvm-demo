package com.kuanhsien.app.sample.android_mvvm_demo.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.kuanhsien.app.sample.android_mvvm_demo.R;
import com.kuanhsien.app.sample.android_mvvm_demo.base.DemoConstants;
import com.kuanhsien.app.sample.android_mvvm_demo.data.database.AppDatabase;
import com.kuanhsien.app.sample.android_mvvm_demo.data.database.InfoDao;
import com.kuanhsien.app.sample.android_mvvm_demo.data.database.ItemInfoDao;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.InfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.ItemInfoModel;


public class DemoRepository {

    private InfoDao mInfoDao;
    private ItemInfoDao mItemInfoDao;

    public DemoRepository(Context context) {

        // use ApplicationContext to get database
        mInfoDao = AppDatabase.getInstance(context.getApplicationContext()).getInfoDao();
        mItemInfoDao = AppDatabase.getInstance(context.getApplicationContext()).getItemInfoDao();
    }

    public void insertInfoAll(InfoModel... info) {
        mInfoDao.insertInfoAll(info);
    }

    public void insertItemAll(ItemInfoModel... items) {
        mItemInfoDao.insertItemAll(items);
    }

    public void prepareData() {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                insertInfoAll(
                        new InfoModel(
                                DemoConstants.AUTHOR,
                                "朱用純",
                                "朱用純（1627年5月29日－1698年四月初七），字致一，自號柏廬，江蘇省崑山縣人，明亡後隱居鄉里以教書為業。\n" +
                                "\n" +
                                "著有《朱柏廬治家格言》（即今之《朱子家訓》）、《刪補易經蒙引》、《四書講義》、《恥躬堂詩文集》、《愧訥集》等。",
                                R.drawable.img_author
                        ),
                        new InfoModel(
                                DemoConstants.COVER,
                                "Cover-Title" ,
                                "Cover-Desc",
                                R.drawable.img_covor
                        )
                );

                insertItemAll(
                        new ItemInfoModel(
                                "1",
                                "一、黎明即起，灑掃庭除..." ,
                                "黎明即起，灑掃庭除，要內外整潔。既昏便息，關鎖門戶，必親自檢點。一粥一飯，當思來處不易；半絲半縷，恒念物力維艱。宜未雨而綢繆，毋臨渴而掘井。自奉必須儉約，宴客切勿留連。器具質而潔，瓦缶勝金玉；飲食約而精，園蔬勝珍饈。勿營華屋，勿謀良田。"
                        ),
                        new ItemInfoModel(
                                "2",
                                "二、三姑六婆，實淫盜之媒..." ,
                                "三姑六婆，實淫盜之媒；婢美妾嬌，非閨房之福。童僕勿用俊美，妻妾切忌豔妝。祖宗雖遠，祭祀不可不誠；子孫雖愚，經書不可不讀。居身務期質樸，教子要有義方。勿貪意外之財，勿飲過量之酒。"
                        ),
                        new ItemInfoModel(
                                "3",
                                "三、與肩挑貿易，勿佔便宜...",
                                "與肩挑貿易，勿佔便宜；見貧苦親鄰，須多溫恤。刻薄成家，理無久享；倫常乖舛，立見消亡。兄弟叔侄，須分多潤寡；長幼內外，宜法肅辭嚴。聽婦言，乖骨肉，豈是丈夫？重貲財，薄父母，不成人子。嫁女擇佳婿，毋索重聘；娶媳求淑女，毋計厚奩。"
                        ),
                        new ItemInfoModel(
                                "4",
                                "四、見富貴而生讒容者，最可恥...",
                                "見富貴而生讒容者，最可恥；遇貧窮而作驕態者，賤莫甚。居家戒爭訟，訟則終凶；處世戒多言，言多必失。毋恃勢力而凌逼孤寡，勿貪口腹而恣殺生禽。乖僻自是，悔誤必多；頹惰自甘，家道難成。狎昵惡少，久必受其累；屈志老成，急則可相依。輕聽發言，安知非人之譖訴，當忍耐三思；因事相爭，安知非我之不是，須平心暗想。"
                        ),
                        new ItemInfoModel(
                                "5",
                                "五、施惠勿念，受恩莫忘...",
                                "施惠勿念，受恩莫忘。凡事當留餘地，得意不宜再往。人有喜慶，不可生妒忌心；人有禍患，不可生喜幸心。善欲人見，不是真善；惡恐人知，便是大惡。見色而起淫心，報在妻女；匿怨而用暗箭，禍延子孫。"
                        ),
                        new ItemInfoModel(
                                "6",
                                "六、家門和順，雖饔飧不繼，亦有餘歡...",
                                "家門和順，雖饔飧不繼，亦有餘歡；國課早完，即囊橐無餘，自得至樂。讀書志在聖賢，非徒科第；為官心存君國，豈計身家？守分安命，順時聽天。為人若此，庶乎近焉。"
                        )
                );
            }
        });
    }

}
