package com.example.notificationoutsideapp;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

/*
Notification:heye tare2a la ezhar resele lal user 5erej l application ya3ne l application bekoun msakar fa bteje message 3ala hay2et notification bekoun ela icon text..etc
bel 3ade l notification betkoun mawjoude bel notification bar le howe l shreet le mawjoud bel shshe fo2 bas tnazlo bebeyen 3andak l wifi on off,kel seeting ta3el telephone
 ya3ne notification heye tare2a la nezher message mo3yane 5erej l application mn 5elel application l notification le mawjoud mosba2an b2lab nezam l android
 nezam l android howe bel asses b2labo application lal notifications le howe lama nes7ab shshe mn 2a3la la asfal byezhar heda l application ne7na mnerselo l notification  le badna nezhro w howe be2om byo3rdlna yeh

 tyeb sho mokawen l notification kel notification ela majmo3a mn l mokawenet ahma:
 1-small icon:icon mos8ara tat3et l application ya3ne logo ta3el l application
 2-app name:esm l application le ejek meno l notification bekoun 7ed l icon taba3 l application
 3-timestamp:l wa2t le tele3t fe notification betkoun 7ed l app name
 4-large icon:icon kbere hay law fe soura mo3yane badak tezhera bel notification metl lama wa7ad yeb3tlk messag 3al watsap betbyen l profile ta3elo
 5-Title:l title taba3 l notification
 6-text:le heye l message ya3ne msln momken ykoun title meen meen ejek l message sho esmo sha5s w text y2olak sho heye l message

 tab3an fe ba3d sha8let momken tkoun bel notification metl ba3d l actions:
  metl button le btkoun ta7t notification malsn reply ,remove fa enta momken tetfe3al mn l notification mendoun ma trou7 3al application nafso metl iza 7ada ba3tlk message 3al watsap fa fek ta3mel reply mn notification nafsa mesh darore enta tente2l 3ala l application la ta3mel reply

 tyeb ana aymta byelzemne 2a3mel notification bel application:
 7asab 7ejtk lal notification msln:
 enta ro7t 3emlt application  a5bar bye3red a5bar badak kel ma t7ades l a5bar bel database te3red notification
 fa 5elel codak ba3d ma tektob ta7des l a5bar betla3e notification lal user bte7kelo eno  ana 7adastelak l a5bar be2mekenak tfout 3al application tshofa msln ba3d ma ta3mel download la file m3yan 2aw music m3yane betale3 notification eno ntha masln l download
 2aw malsn ba3d ma tersel sora mn 5elel l bloototh la 7ada 2aw 3an tare2 l wifi direct momken tale3lo mesage eno l ana arsalt hay l soura
 ya3ne este5dem l notification 7asab 7ejtak ma ela kawa3ed m3yane


hala2 le badna net3alamo eno keef ntale3 notification lal user keef na3mela ya3ne la7 net3lam keef nektob code mo3yan ytale3lna notification b 5asa2es mo3yane:

hala2 fe far2 keef mnet3emal ma3 notification 7asb l version l android:

hala2 l android mn 26 w tlo3 elo tare2a m3yane 3emlo she esmo notification chanel:
fekret notification chanel:eno sam7lak tejma3a akatr mn  notification bsha8le metl l package ya3ne eja alak badel ma enta temsek kel notification a7ala  w ta3mela 5asa2es mo3yane ta3mela mute ta3mela ta3etel el8e2 ta3mel aye she tafaselha 2alwena icons tab3eta momken enta alak badal ma ta3mel la kel notification la7ala hawde momken tjame3oun lal notification b2lab she esmo notification chanel  w t8ayer 5asa2es l chanel nafsa mesh notification 7a nshofa ba3den


hala2 iza keen l version 26 w ma fo2 lezm ta3mel create notification chanel ama iza keen 2a2al mn 26 ma feek ta3mela lal notification chanel
ya3ne hala2 iza badna na3mel notitification la android 26 w fo2:

2awl she create notification chanel-->build notification-->publish notification 2aw 3ard notification

law 2a2al mn 26 version l android build notification-->publish notification 2aw 3ard notification


bade 2a3mel application fe button esma notification bas ekbous 3lyha lal button bado ytale3le notification

hala2 mafroud jowa code l button rou7 2a3mel ezhar lal notification
3ashen ykoun l code mratab bade 2a3mel method esma displaynotification() w 7ota bel onclick w b2lab l function l displaynotification 2a3mel code l notification

1-hala2 2awal she bade 2a3mel check 3ala aye version bel android iza akbar mn 26 equll 2aw az8ar l2no la7 bte5tlef l immplimentation iza akbar w equll mn 26 2aw az8ar mn 26
l2no 2olna iza akbar w equll mn 26 lezm 2a3mel notification chanel
fa beje ba3mel if l version l adnroid akbar 2aw besewe 26:Build.VERSION.SDK_INT>=Build.VERSION_CODES.O iza l version l android le heye l sdk le b2lab telephone akbar 2aw btsewe version l android O le heye 26 rou7 3mele notification chanel

keef ba3mel notification chanel:
fe class 3ande esmo NotificationChannel ba3mel meno object :NotificationChannel channel=new NotificationChannel() bte5od 3 parameter l NotificationChannel 2awl parameter howe l id kel channel lezm ykoun 3anda id fa b3ref id bara final w heda l id unique ma byetkarar lesh 3ashn lama bade 3adel 5asa2es  mo3yane  t3adel mn 5elel l id law badak te7zefa ta3mel aye she ta3mlo mn 5elel l id fa b3rfo id howe l id string  public static final String CHANEL_ID="x_channelId"; hed 2awal parameter tene parameter howe name esm l channel heda l esm le bado yezhar 5ale belak  l id de5lyan 3ashen yet3emal ma3o  lama bado ya3mel 5asa2es 2aw bado ye7zef 2aw yel8e ..ect,laken display name howe l esm le bado yezhar le bado ye3rdo lal most5dem le enta 7a tshofo b 3aynak law fout 3ala setting badak ta3mel aye 2e3dadet fa houn bade 2a3te esm mo3yan bade same malsn "CHANNEL display name" ba3d shway bas n2ol channel dispaly name netzakar hed esm l channel,e5er parameter howe she esmo importance 3ebra 3an integer howe darajet ahmyet l channel nafsa 3ande ana darajet  mn l importance metl IMORTANCE_HIGH,LOW,UNSPECIFIED,NONE,MIN,DEFAULT haw l importance 2aw l ahmeye  l 5asa bel channel nafsa bt7adedalk adesh l channel hayde enta btla7ez ba3d notification bteje la tel8eha ma btelte8e bedala m3l2a meetl wa2t ykoun bel telephone water ma btelte8e notification ela la yrou7 l may mn telephone w fe l notification betkoun b 2awal l lista ta3et notificatio 3atoul betkoun 3ana 10 notification law ejena reselet instagram btl2eha malsn tele3et 2awal wa7de bel notification mn fo2 2awal lista lesh l2no l importance taba3 notification chanel taba3a 3alye 2aw l priority ta3et l channel 3alye hay l ma2sod bel importance hala2 5aleha default l importance law enta ma btefre2 ma3ak l priority taba3a iza btefre2 ma3ak 7ota high btseer metl l notification ta3wlet system bteje 2awal wa7de w be2e notification koloun byejo ta7ta
hala2 ansha2t l channel hala2 law badak t7ot wasf m3yan lal chaneel hayde bshakl eno l user l 3ade momken yshof tafasel yshof description  taba3et l channel fa bt2olo channel dot setDescription("") mskn bt2olo my channel description w 5ale belak 2no l channel bye2dar  l user yshofaha w bye2dar yfout 3ala 2e3dadeta w bye2dar y3atela w bye2dar ya3mel tanbeh ela bye2dar ya3mel l bado yeh
5alast l channel w 5alst 2e3dadeta beje benshe2 l channel hay
keef benshe2a:
fe she 3ande esmo NotificationManager class:heda 3ebara 3an class bya3mel manage lal notification fa b3ref object meno b2olo NotificationManager nm equll getSystemService()
getSystemService():ya3ne hetle system service taba3 Notification_Manager le mawjoud 3ande bel android ba3te b2lab l getsystemService(Notification_Manager.class);
NotificationManager nm=getSystemService(NotificationManager.class);:heda satr ma3neto eno ana bade jeeb class l manager l 5as bel notification 3ashen 2e2dar mn 5elel l manger deef channel l manager metl ma mna3ref eno mn 5elelo ana bdeef channel mn 5elelo ana bdeef notification aye sha8le ela 3ela2a bel notification brou7 benshe2a mn 5elel l manager
tyeb lesh ma 3mlt new NotificationManager() 3mlt getSystemService()
l2no already 2olna eno fe 3ande metl application bult in b2lab l adnroid  3ebra 3an application mawjoud bel android nafso bas nazel shshe bebyn l notification mn 5elelo fa enta ma badak tenshe2 sha8le jdede badak test5dem she mawjoud k2nak bt2olo 3atene service taba3et notification w rou7 enshe2 3lyha channel ya3ne heye mesh app bel zabt heye service bult in bta3mel mange lal notification le heye l notification manager mnjeba w mn7ot feha chanel ba3den mnseer mnzeed 3ala l chanel notifications
ba3den btenshe2 channel keef bt2olo notificationmanager nshe2le b2laba notificationchannel: nm.createNotificationChannel() w b3tee l notification channel le 3mlta ana nm.createNotificationChannel(channel)
heek ana bkoun ansha2t l channel aymta anshe2ta wa2t tkoun l version akbar 2aw equllmn 26

hala2 houn ma ba3mel esle heda shart ba3mlo bas iza ken l versio 2a3la 2aw equllmn 26 w l be2e l eshya ba3meloun common been l 26 w aktar w 2a2al mn 26


hala2 bade enshe2 notification nafsa:
fe 3ande class esmo NotificationCompat: aye class fe b2labo Compat ya3ne mnet3emal ma3 support library 2aw android x lesh best5dmo l2no fe versions ademe w fe version ademe fa ana bade 7ewel adr l emken  5ale l application ta3ele shemel la kel l versions l mawjoude 3ande
NotificationCompat dot  Builder heda class l bulder mn 5elelo ana ba3mel build la notification w ba3ed heek bo3reda  fa beje b2olo NotificationCompat.Builder builder equll new NotificationCompat.Builder() w ba3te sha8lten l context w sha8le tenye heye l channel id 3ashen iza keen fe Notificationchanel yorbto mn 5elel l channelid w iza ma fe 5als byet3emal ma3 l channel id 5ale belak mesh darore  eno ykoun 3ande channel mawjoude ana bel neheye iza l version akabr 2aw besewe 26 byelzmne channel 8eer heek ma byelzmne
NotificationCompat.Builder builder=new NotificationCompat.Builder(getBaseContext(),CHANEL_ID);:

hala2 bade 2a3mel 5asa2es ta3et l notification:
fe 3ande 5asa2es kteer 3al lal notification

fe 3ande masln
bulider.setsmallIcon():
bulder.setcontentTitle()
bulder.setcontextText("")
bulder.setpriority():l 2awlaweye ta3eta hay bteshbah l importance fene 2olo NotificationCompat.Priority_High ya3ne bade 2awlaweye 3alye eno dala mawjoude notification fo2
bulder.setstyle():malsn style bade big picture style,Messegaing style mn 5elel new NotificationComapt.bigtextStyle.bigText("hello")
bulder.AddAction()hayde 3ashen ta3ete button m3yane bas tekbous 3leee yseer action bt3te icon R.drawble.pic,tene parameter title reply,telet wa7d howe l PendingIntent
sho howe l PendingIntent:eno ana lama bade ed8at 3ala hayda l action bado y7awelne 3ala l intent hay k2no l action 3ebra 3an button mawjoud bede5el l notification lama ed8at 3lee bado yen2elne 3ala intent mo3yane hay l intent ne7na mnsameha pending intent mesh nafs l intent l 3adeye hay mo3ale2a ya3ne hay ma btetnafaz ela mn 5elel zpplication tene b ma3na l inetnt l 3adeye lama kona nest5dema  intent intent=new intent() w start activity fa keen ysha8ela hay intent 3adeye  laken l Pending Intent:
l pending intent best5dema lama bade ersela la application tene 3ashen l application tene ysha8lea
ne7na 7kena eno notification  btezahr demn application l notifications le mawjoud bel system laken ana bo3roud notification b application mesh la2ele laken lama ykoun fe action b notification  le heye asln b application mesh la2ele mafroud lama wa7ad yed8at 3ala l action heda w bade sha8el l activity taba3te fa l activity tab3te  bada teshte8l mn 5elel amr mn bara l application ta3ele fa 3ashen heek best5dem pending intent ay application 5ereje 8eer l application ta3ele bye7tej yetwasal ma3 intent bta3melo pending intent intent mo3la2 beste5dema 3ala amr mn application tenye 5erejey 5erej l application ta3elak
keef ba3mel pending intent:
heye intent 3adeye bas bdefa b class pending intent
ba3mel intent b5elaha bel class heda this,ba3den bada tefta7 l main activity bade bas yekbous l user 3ala action yefta7 l mainactivity
Intent intent=new Intent(this,MainActivity.class);

ba3den ba3mel PendingIntent:
PendingIntent pi= PendingIntent.getActivity() 3ashen yejble l activity le bel intent hay le heye l PendingIntent   w ba3te l context this ,result code maln 0,l intent tab3te intent,ba3den flag kamen mesh daroee 0

hala2 law bade e3roud l notification
3ande class esmo NotificationManagerCompat
ba3mel meno instance
NotificationManagerCompat nmc= new NotificationManagerCompat.from(this); ba3te l context ba3den
ba3den b2olo 3emlo notify ya3ne push lal notification
nmc.notify() w houn fe mola7aza metl ma kel chanel ela id kel notification ela id fa ba3teh id mn 5elel l nmc.notify(10)
l2no law badak te7zefa ba3d heek bt7ozefa mn 5elel heda l id

w ba3teha la notify kamen tene parameter l bulder le 3mlto dot build 3asehn ya3mele bene2 ela lal notification  w 3ardle yeha lal user

e5er sha8le eno ne7na ma fena na3mel notification bala persmion fa mna3mel persmion 2awal she lal notification
bas l android version mn 33 w tlo3 la ta3mel notification be7je la permisiion 8eer hek android version ma bte7tej la permission


fe ba3d attribute esma builder.setcontentintent()hyde kamen bte5od pending entent bas hay btetnafaz eza da8t 3ala kel notification



















 */


public class MainActivity extends AppCompatActivity {

    public static final String CHANEL_ID = "x_channelId";

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btn_notification);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1);

            }
        }
        button.setOnClickListener(v -> {
            displaynotification();
        });


    }

    private void displaynotification() {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE, null);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANEL_ID, "CHANNEL display name", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("my channel description");
            NotificationManager nm = getSystemService(NotificationManager.class);
            nm.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getBaseContext(), CHANEL_ID);
        builder.setContentTitle("my Title")
                .setSmallIcon(R.drawable.baseline_notifications_24)
                .setContentText("Plah Pah pdpdpfpfpfpf")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pi)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("my data"))
                .addAction(R.drawable.baseline_notifications_24, "Replay", pi);

        NotificationManagerCompat nmc = NotificationManagerCompat.from(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED)
            nmc.notify(10, builder.build());


    }
}