package com.zagzoug.qourankariem;

import android.app.NotificationManager;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.zagzoug.qourankariem.adapter.MViewPagerAdapter;

public class QouranPager extends AppCompatActivity {
    public static final String KEY_INDEX = "key";
    public static final String INDEX_SOURA = "soura";
    public static final String INDEX_GOZA = "GOZA";
    public static final String INDEX_PAGES = "PAGES";
    private static final String SHARED_FILE = "save_image";
    public static final String SHARED_FILE1 = "save";
    private static final String KEY_SAVE = "save";
    public static final String KEY_tafsir = "key";
    private static final String KEY_SAVE1 = "keyh";
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qouran_pager);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new MViewPagerAdapter(getSupportFragmentManager(), Page.getReverse()));

        viewPager.requestFocus();
        SharedPreferences shared = getSharedPreferences(SHARED_FILE1, MODE_PRIVATE);

        int pageSaved = shared.getInt(KEY_SAVE1, 604);


        int pageNumber = getIntent().getIntExtra(IndexActivity.KEY_PAGE, -1);


        if (pageNumber != -1) {
            viewPager.setCurrentItem(pageNumber);
        } else {
            viewPager.setCurrentItem(pageSaved);
        }
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(0);
        MediaPlayer mediaPlayer=new MediaPlayer();
        mediaPlayer.stop();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }


            @Override
            public void onPageSelected(int position) {
                int reversePage = 604 - position;
                getRoba(reversePage);


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_qouran_pager, menu);

                return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {

            case R.id.index_soura:
                intent = new Intent(this, IndexActivity.class);
                intent.putExtra(KEY_INDEX, INDEX_SOURA);
                startActivity(intent);
                break;
            case R.id.index_pages:
                intent = new Intent(this, IndexActivity.class);
                intent.putExtra(KEY_INDEX, INDEX_PAGES);
                startActivity(intent);
                break;
            case R.id.index_goza:
                intent = new Intent(this, IndexActivity.class);
                intent.putExtra(KEY_INDEX, INDEX_GOZA);
                startActivity(intent);

                break;
            case R.id.save_page:
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_FILE, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(KEY_SAVE, viewPager.getCurrentItem());
                editor.apply();
                Toast.makeText(this, "لقد تم حفظ الصفحه ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.page_saved:
                SharedPreferences shared = getSharedPreferences(SHARED_FILE, MODE_PRIVATE);

                int pageSaved = shared.getInt(KEY_SAVE, -1);
                if (pageSaved == -1) {
                    Toast.makeText(this, "للاسف انت لم تحفظ اى صفحه", Toast.LENGTH_SHORT).show();
                } else {
                    viewPager.setCurrentItem(pageSaved);
                }
                break;
            case R.id.tafsir:
                intent = new Intent(this, Tafsir.class);
                intent.putExtra(KEY_tafsir, 604 - viewPager.getCurrentItem());
                startActivity(intent);
                break;

            case R.id.end:
                intent = new Intent(this, End.class);
                startActivity(intent);
                break;
            case R.id.alarm_menu:
                intent = new Intent(this, AlarmActivity.class);
                startActivity(intent);
                break;
            case R.id.about:
                intent = new Intent(this, About.class);
                startActivity(intent);
                break;
          /*  case R.id.asbab:
                intent = new Intent(this, AsbabAlnozol.class);
                startActivity(intent);
                break;
            case R.id.search:
                intent = new Intent(this, Searching.class);
                startActivity(intent);
                break;*/
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder exit = new AlertDialog.Builder(this);
        exit.setMessage("هل تريد الخروج فعلا");
        exit.setNegativeButton("نعم", new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                finishAffinity();
                Toast.makeText(QouranPager.this, "سبحان الله و بحمده... سبحان الله العظيم", Toast.LENGTH_SHORT).show();
            }
        });
        exit.setPositiveButton("لا ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                exit.create().dismiss();
            }
        });
        exit.create().show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_FILE1, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_SAVE1, viewPager.getCurrentItem());
        editor.apply();
    }

    private void getRoba(int reversePage) {
        switch (reversePage) {
            case 2:
            case 3:
            case 4:
            case 6:
            case 8:
            case 10:
            case 12:
            case 13:
            case 15:
            case 16:
            case 18:
            case 20:
            case 21:
            case 23:
            case 25:
            case 26:
            case 28:
            case 30:
            case 31:
            case 33:
            case 35:
            case 36:
            case 38:
            case 40:
            case 41:
            case 43:
            case 45:
            case 47:
            case 48:
            case 50:
            case 52:
            case 53:
            case 55:
            case 57:
            case 58:
            case 60:
            case 61:
            case 63:
            case 65:
            case 66:
            case 68:
            case 70:
            case 71:
            case 73:
            case 75:
            case 76:
            case 78:
            case 80:
            case 81:
            case 83:
            case 85:
            case 86:
            case 88:
            case 90:
            case 91:
            case 93:
            case 95:
            case 96:
            case 98:
            case 99:
            case 101:
            case 103:
            case 105:
            case 107:
            case 108:
            case 110:
            case 111:
            case 113:
            case 115:
            case 116:
            case 118:
            case 120:
            case 122:
            case 123:
            case 125:
            case 127:
            case 128:
            case 130:
            case 131:
            case 133:
            case 135:
            case 136:
            case 138:
            case 139:
            case 141:
            case 143:
            case 145:
            case 147:
            case 149:
            case 150:
            case 152:
            case 153:
            case 155:
            case 157:
            case 159:
            case 160:
            case 161:
            case 163:
            case 165:
            case 166:
            case 168:
            case 169:
            case 171:
            case 172:
            case 174:
            case 176:
            case 178:
            case 180:
            case 181:
            case 183:
            case 185:
            case 186:
            case 188:
            case 190:
            case 191:
            case 193:
            case 195:
            case 197:
            case 198:
            case 200:
            case 202:
            case 203:
            case 205:
            case 207:
            case 208:
            case 210:
            case 211:
            case 213:
            case 215:
            case 216:
            case 218:
            case 220:
            case 221:
            case 223:
            case 225:
            case 227:
            case 229:
            case 230:
            case 232:
            case 234:
            case 235:
            case 237:
            case 239:
            case 240:
            case 241:
            case 243:
            case 245:
            case 246:
            case 248:
            case 250:
            case 251:
            case 253:
            case 255:
            case 257:
            case 258:
            case 260:
            case 261:
            case 263:
            case 265:
            case 266:
            case 268:
            case 269:
            case 271:
            case 273:
            case 274:
            case 276:
            case 278:
            case 279:
            case 281:
            case 283:
            case 285:
            case 286:
            case 288:
            case 290:
            case 291:
            case 293:
            case 294:
            case 296:
            case 298:
            case 300:
            case 301:
            case 303:
            case 305:
            case 307:
            case 308:
            case 310:
            case 311:
            case 313:
            case 314:
            case 316:
            case 318:
            case 320:
            case 321:
            case 323:
            case 325:
            case 327:
            case 328:
            case 330:
            case 331:
            case 333:
            case 335:
            case 337:
            case 338:
            case 340:
            case 341:
            case 343:
            case 345:
            case 346:
            case 348:
            case 349:
            case 351:
            case 353:
            case 355:
            case 357:
            case 358:
            case 360:
            case 361:
            case 363:
            case 365:
            case 366:
            case 368:
            case 370:
            case 372:
            case 373:
            case 375:
            case 376:
            case 378:
            case 380:
            case 381:
            case 383:
            case 385:
            case 387:
            case 388:
            case 390:
            case 391:
            case 393:
            case 395:
            case 397:
            case 398:
            case 400:
            case 401:
            case 403:
            case 405:
            case 406:
            case 408:
            case 409:
            case 411:
            case 412:
            case 414:
            case 416:
            case 417:
            case 419:
            case 421:
            case 423:
            case 424:
            case 427:
            case 428:
            case 430:
            case 432:
            case 434:
            case 435:
            case 437:
            case 438:
            case 440:
            case 441:
            case 443:
            case 445:
            case 447:
            case 448:
            case 450:
            case 452:
            case 453:
            case 455:
            case 457:
            case 458:
            case 460:
            case 461:
            case 463:
            case 465:
            case 466:
            case 468:
            case 470:
            case 471:
            case 473:
            case 475:
            case 476:
            case 478:
            case 480:
            case 481:
            case 483:
            case 485:
            case 487:
            case 489:
            case 490:
            case 492:
            case 494:
            case 495:
            case 497:
            case 498:
            case 500:
            case 501:
            case 503:
            case 504:
            case 506:
            case 508:
            case 509:
            case 511:
            case 512:
            case 514:
            case 516:
            case 518:
            case 520:
            case 521:
            case 523:
            case 525:
            case 527:
            case 528:
            case 530:
            case 532:
            case 533:
            case 535:
            case 537:
            case 538:
            case 540:
            case 541:
            case 543:
            case 545:
            case 546:
            case 548:
            case 549:
            case 551:
            case 552:
            case 555:
            case 556:
            case 557:
            case 559:
            case 561:
            case 563:
            case 565:
            case 567:
            case 568:
            case 570:
            case 571:
            case 573:
            case 574:
            case 576:
            case 578:
            case 580:
            case 581:
            case 583:
            case 584:
            case 586:
            case 588:
            case 590:
            case 592:
            case 593:
            case 595:
            case 597:
            case 598:
            default:
                return;

            case 1:
                toast_show("بدايه الحزب 1 الجزء" + Page.getGozaName()[0]);
                return;
            case 5:
                toast_show("ربع الحزب 1 الجزء" + Page.getGozaName()[0]);
                return;

            case 7:
                toast_show("نصف الحزب 1 الجزء" + Page.getGozaName()[0]);
                return;
            case 9:
                toast_show("ثلاثه ارباع الحزب 1 الجزء" + Page.getGozaName()[0]);
                return;
            case 11:
                Toast.makeText(this, "بدايه الحزب2  الجزء ", Toast.LENGTH_SHORT).show();
                return;
            case 14:
                toast_show("ربع الحزب2 الجزء" + Page.getGozaName()[0]);
                return;
            case 17:
                toast_show("نصف الحزب 2 الجزء" + Page.getGozaName()[0]);

                return;
            case 19:
                toast_show("ثلاثه ارباع الحزب 2  الجزء" + Page.getGozaName()[0]);
                return;
            case 22:
                toast_show("بدايه الحزب 3 الجزء" + Page.getGozaName()[1]);
                return;
            case 24:
                toast_show("ربع الحزب 3 الجزء" + Page.getGozaName()[1]);
                return;
            case 27:
                toast_show("نصف الحزب 3 الجزء" + Page.getGozaName()[1]);
                return;
            case 29:
                toast_show("ثلاثه ارباع الحزب 3 الجزء" + Page.getGozaName()[1]);
                return;
            case 32:
                toast_show("بدايه الحزب 4 الجزء" + Page.getGozaName()[1]);
                return;
            case 34:
                toast_show("ربع الحزب 4 الجزء" + Page.getGozaName()[1]);
                return;
            case 37:
                toast_show("نصف الحزب 4 الجزء" + Page.getGozaName()[1]);
                return;
            case 39:
                toast_show("ثلاثه ارباع الحزب 4 الجزء" + Page.getGozaName()[1]);
                return;
            case 42:
                toast_show("بدايه الحزب 5 الجزء" + Page.getGozaName()[2]);
                return;
            case 44:
                toast_show("ربع الحزب 5 الجزء" + Page.getGozaName()[2]);
                return;
            case 46:
                toast_show("نصف الحزب 5 الجزء" + Page.getGozaName()[2]);
                return;
            case 49:
                toast_show("ثلاثه ارباع الحزب 5 الجزء" + Page.getGozaName()[2]);
                return;
            case 51:
                toast_show("بدايه الحزب 6 الجزء" + Page.getGozaName()[2]);
                return;
            case 54:
                toast_show("ربع الحزب 6 الجزء" + Page.getGozaName()[2]);
                return;
            case 56:
                toast_show("نصف الحزب 6 الجزء" + Page.getGozaName()[2]);
                return;
            case 59:
                toast_show("ثلاثه ارباع الحزب 6 الجزء" + Page.getGozaName()[2]);
                return;
            case 62:
                toast_show("بدايه الحزب 7 الجزء" + Page.getGozaName()[3]);
                return;
            case 64:
                toast_show("ربع الحزب 7 الجزء" + Page.getGozaName()[3]);
                return;
            case 67:
                toast_show("نصف الحزب 7 الجزء" + Page.getGozaName()[3]);
                return;
            case 69:
                toast_show("ثلاثه ارباع الحزب 7 الجزء" + Page.getGozaName()[3]);
                return;
            case 72:
                toast_show("بدايه الحزب 8 الجزء" + Page.getGozaName()[3]);
                return;
            case 74:
                toast_show("ربع الحزب 8 الجزء" + Page.getGozaName()[3]);
                return;
            case 77:
                toast_show("نصف الحزب 8 الجزء" + Page.getGozaName()[3]);
                return;
            case 79:
                toast_show("ثلاثه ارباع الحزب 8 الجزء" + Page.getGozaName()[3]);
                return;
            case 82:
                toast_show("بدايه الحزب 9 الجزء" + Page.getGozaName()[4]);
                return;
            case 84:
                toast_show("ربع الحزب 9 الجزء" + Page.getGozaName()[4]);
                return;
            case 87:
                toast_show("نصف الحزب 9 الجزء" + Page.getGozaName()[4]);
                return;
            case 89:
                toast_show("ثلاثه ارباع الحزب 9 الجزء" + Page.getGozaName()[4]);
                return;
            case 92:
                toast_show("بدايه الحزب 10 الجزء" + Page.getGozaName()[4]);
                return;
            case 94:
                toast_show("ربع الحزب 10 الجزء" + Page.getGozaName()[4]);
                return;
            case 97:
                toast_show("نصف الحزب 10 الجزء" + Page.getGozaName()[4]);
                return;
            case 100:
                toast_show("ثلاثه ارباع الحزب 10 الجزء" + Page.getGozaName()[4]);
                return;
            case 102:
                toast_show("بدايه الحزب 11 الجزء" + Page.getGozaName()[5]);
                return;
            case 104:
                toast_show("ربع الحزب 11 الجزء" + Page.getGozaName()[5]);
                return;
            case 106:
                toast_show("نصف الحزب 11 الجزء" + Page.getGozaName()[5]);
                return;
            case 109:
                toast_show("ثلاثه ارباع الحزب 11 الجزء" + Page.getGozaName()[5]);
                return;
            case 112:
                toast_show("بدايه الحزب 12 الجزء" + Page.getGozaName()[5]);
                return;
            case 114:
                toast_show("ربع الحزب 12 الجزء" + Page.getGozaName()[5]);
                return;
            case 117:
                toast_show("نصف الحزب 12 الجزء" + Page.getGozaName()[5]);
                return;
            case 119:
                toast_show("ثلاثه ارباع الحزب 12 الجزء" + Page.getGozaName()[5]);
                return;
            case 121:
                toast_show("بدايه الحزب 13 الجزء" + Page.getGozaName()[6]);
                return;
            case 124:
                toast_show("ربع الحزب 13 الجزء" + Page.getGozaName()[6]);
                return;
            case 126:
                toast_show("نصف الحزب 13 الجزء" + Page.getGozaName()[6]);
                return;
            case 129:
                toast_show("ثلاثه ارباع الحزب 13 الجزء" + Page.getGozaName()[6]);
                return;
            case 132:
                toast_show("بدايه الحزب 14 الجزء" + Page.getGozaName()[6]);
                return;
            case 134:
                toast_show("ربع الحزب 14 الجزء" + Page.getGozaName()[6]);
                return;
            case 137:
                toast_show("نصف الحزب 14 الجزء" + Page.getGozaName()[6]);
                return;
            case 140:
                toast_show("ثلاثه ارباع الحزب 14 الجزء" + Page.getGozaName()[6]);
                return;
            case 142:
                toast_show("بدايه الحزب 15 الجزء" + Page.getGozaName()[7]);
                return;
            case 144:
                toast_show("ربع الحزب 15 الجزء" + Page.getGozaName()[7]);
                return;
            case 146:
                toast_show("نصف الحزب 15 الجزء" + Page.getGozaName()[7]);
                return;
            case 148:
                toast_show("ثلاثه ارباع الحزب 15 الجزء" + Page.getGozaName()[7]);
                return;
            case 151:
                toast_show("بدايه الحزب 16 الجزء" + Page.getGozaName()[7]);
                return;
            case 154:
                toast_show("ربع الحزب 16 الجزء" + Page.getGozaName()[7]);
                return;
            case 156:
                toast_show("نصف الحزب 16 الجزء" + Page.getGozaName()[7]);
                return;
            case 158:
                toast_show("ثلاثه ارباع الحزب 16 الجزء" + Page.getGozaName()[7]);
                return;
            case 162:
                toast_show("بدايه الحزب 17 الجزء" + Page.getGozaName()[8]);
                return;
            case 164:
                toast_show("ربع الحزب 17 الجزء" + Page.getGozaName()[8]);
                return;
            case 167:
                toast_show("نصف الحزب 17 الجزء" + Page.getGozaName()[8]);
                return;
            case 170:
                toast_show("ثلاثه ارباع الحزب 17 الجزء" + Page.getGozaName()[8]);
                return;
            case 173:
                toast_show("بدايه الحزب 17 الجزء" + Page.getGozaName()[8]);
                return;
            case 175:
                toast_show("ربع الحزب 18 الجزء" + Page.getGozaName()[8]);
                return;
            case 177:
                toast_show("نصف الحزب 18 الجزء" + Page.getGozaName()[8]);
                return;
            case 179:
                toast_show("ثلاثه ارباع الحزب 18 الجزء" + Page.getGozaName()[8]);
                return;
            case 182:
                toast_show("بدايه الحزب 19 الجزء" + Page.getGozaName()[9]);
                return;
            case 184:
                toast_show("ربع الحزب 19 الجزء" + Page.getGozaName()[9]);
                return;
            case 187:
                toast_show("نصف الحزب 19 الجزء" + Page.getGozaName()[9]);
                return;
            case 189:
                toast_show("ثلاثه ارباع الحزب 19 الجزء" + Page.getGozaName()[9]);
                return;
            case 192:
                toast_show("بدايه الحزب 20 الجزء" + Page.getGozaName()[9]);
                return;
            case 194:
                toast_show("ربع الحزب 20 الجزء" + Page.getGozaName()[9]);
                return;
            case 196:
                toast_show("نصف الحزب 20 الجزء" + Page.getGozaName()[9]);
                return;
            case 199:
                toast_show("ثلاثه ارباع الحزب 20 الجزء" + Page.getGozaName()[9]);
                return;
            case 201:
                toast_show("بدايه الحزب 21 الجزء" + Page.getGozaName()[10]);
                return;
            case 204:
                toast_show("ربع الحزب 21 الجزء" + Page.getGozaName()[10]);
                return;
            case 206:
                toast_show("نصف الحزب 21 الجزء" + Page.getGozaName()[10]);
                return;
            case 209:
                toast_show("ثلاثه ارباع الحزب 21 الجزء" + Page.getGozaName()[10]);
                return;
            case 212:
                toast_show("بدايه الحزب 22 الجزء" + Page.getGozaName()[10]);
                return;
            case 214:
                toast_show("ربع الحزب 22 الجزء" + Page.getGozaName()[10]);
                return;
            case 217:
                toast_show("نصف الحزب 22 الجزء" + Page.getGozaName()[10]);
                return;
            case 219:
                toast_show("ثلاثه ارباع الحزب 22 الجزء" + Page.getGozaName()[10]);
                return;
            case 222:
                toast_show("بدايه الحزب 23 الجزء" + Page.getGozaName()[11]);
                return;
            case 224:
                toast_show("ربع الحزب 23 الجزء" + Page.getGozaName()[11]);
                return;
            case 226:
                toast_show("نصف الحزب 23 الجزء" + Page.getGozaName()[11]);
                return;
            case 228:
                toast_show("ثلاثه ارباع الحزب 23 الجزء" + Page.getGozaName()[11]);
                return;
            case 231:
                toast_show("بدايه الحزب 24 الجزء" + Page.getGozaName()[11]);
                return;
            case 233:
                toast_show("ربع الحزب 24 الجزء" + Page.getGozaName()[11]);
                return;
            case 236:
                toast_show("نصف الحزب 24 الجزء" + Page.getGozaName()[11]);
                return;
            case 238:
                toast_show("ثلاثه ارباع الحزب 24 الجزء" + Page.getGozaName()[11]);
                return;
            case 242:
                toast_show("بدايه الحزب 25 الجزء" + Page.getGozaName()[12]);
                return;
            case 244:
                toast_show("ربع الحزب 25 الجزء" + Page.getGozaName()[12]);
                return;
            case 247:
                toast_show("نصف الحزب 25 الجزء" + Page.getGozaName()[12]);
                return;
            case 249:
                toast_show("ثلاثه ارباع الحزب 25 الجزء" + Page.getGozaName()[12]);
                return;
            case 252:
                toast_show("بدايه الحزب 26 الجزء" + Page.getGozaName()[12]);
                return;
            case 254:
                toast_show("ربع الحزب 26 الجزء" + Page.getGozaName()[12]);
                return;
            case 256:
                toast_show("نصف الحزب 26 الجزء" + Page.getGozaName()[12]);
                return;
            case 259:
                toast_show("ثلاثه ارباع الحزب 26 الجزء" + Page.getGozaName()[12]);
                return;
            case 262:
                toast_show("بدايه الحزب 27 الجزء" + Page.getGozaName()[13]);
                return;
            case 264:
                toast_show("ربع الحزب 27 الجزء" + Page.getGozaName()[13]);
                return;
            case 267:
                toast_show("نصف الحزب 27  الجزء" + Page.getGozaName()[13]);
                return;
            case 270:
                toast_show("ثلاثه ارباع الحزب 27 الجزء" + Page.getGozaName()[13]);
                return;
            case 272:
                toast_show("بدايه الحزب 28 الجزء" + Page.getGozaName()[013]);
                return;
            case 275:
                toast_show("ربع الحزب 28 الجزء" + Page.getGozaName()[013]);
                return;
            case 277:
                toast_show("نصف الحزب 28 الجزء" + Page.getGozaName()[013]);
                return;
            case 280:
                toast_show("ثلاثه ارباع الحزب 28 الجزء" + Page.getGozaName()[013]);
                return;
            case 282:
                toast_show("بدايه الحزب 29 الجزء" + Page.getGozaName()[014]);
                return;
            case 284:
                toast_show("ربع الحزب 29 الجزء" + Page.getGozaName()[014]);
                return;
            case 287:
                toast_show("نصف الحزب 29 الجزء" + Page.getGozaName()[014]);
                return;
            case 289:
                toast_show("ثلاثه ارباع الحزب 29 الجزء" + Page.getGozaName()[014]);
                return;
            case 292:
                toast_show("بدايه الحزب 30 الجزء" + Page.getGozaName()[014]);
                return;
            case 295:
                toast_show("ربع الحزب 30 الجزء" + Page.getGozaName()[014]);
                return;
            case 297:
                toast_show("نصف الحزب 30 الجزء" + Page.getGozaName()[014]);
                return;
            case 299:
                toast_show("ثلاثه ارباع الحزب 30 الجزء" + Page.getGozaName()[014]);
                return;
            case 302:
                toast_show("بدايه الحزب 31 الجزء" + Page.getGozaName()[015]);
                return;
            case 304:
                toast_show("ربع الحزب 31 الجزء" + Page.getGozaName()[015]);
                return;
            case 306:
                toast_show("نصف الحزب 31 الجزء" + Page.getGozaName()[015]);
                return;
            case 309:
                toast_show("ثلاثه ارباع الحزب 31 الجزء" + Page.getGozaName()[015]);
                return;
            case 312:
                toast_show("بدايه الحزب 32 الجزء" + Page.getGozaName()[015]);
                return;
            case 315:
                toast_show("ربع الحزب 32 الجزء" + Page.getGozaName()[015]);
                return;
            case 317:
                toast_show("نصف الحزب 32 الجزء" + Page.getGozaName()[015]);
                return;
            case 319:
                toast_show("ثلاثه ارباع الحزب 32 الجزء" + Page.getGozaName()[015]);
                return;
            case 322:
                toast_show("بدايه الحزب 33 الجزء" + Page.getGozaName()[016]);
                return;
            case 324:
                toast_show("ربع الحزب 33 الجزء" + Page.getGozaName()[016]);
                return;
            case 326:
                toast_show("نصف الحزب 33 الجزء" + Page.getGozaName()[016]);
                return;
            case 329:
                toast_show("ثلاثه ارباع الحزب 33 الجزء" + Page.getGozaName()[016]);
                return;
            case 332:
                toast_show("بدايه الحزب 34 الجزء" + Page.getGozaName()[016]);
                return;
            case 334:
                toast_show("ربع الحزب 34 الجزء" + Page.getGozaName()[016]);
                return;
            case 336:
                toast_show("نصف الحزب 34 الجزء" + Page.getGozaName()[016]);
                return;
            case 339:
                toast_show("ثلاثه ارباع الحزب 34 الجزء" + Page.getGozaName()[016]);
                return;
            case 342:
                toast_show("بدايه الحزب35  الجزء" + Page.getGozaName()[17]);
                return;
            case 344:
                toast_show("ربع الحزب 35 الجزء" + Page.getGozaName()[17]);
                return;
            case 347:
                toast_show("نصف الحزب  35 الجزء" + Page.getGozaName()[17]);
                return;
            case 350:
                toast_show("ثلاثه ارباع الحزب 35 الجزء" + Page.getGozaName()[17]);
                return;
            case 352:
                toast_show("بدايه الحزب 36  الجزء" + Page.getGozaName()[17]);
                return;
            case 354:
                toast_show("ربع الحزب 36 الجزء" + Page.getGozaName()[17]);
                return;
            case 356:
                toast_show("نصف الحزب 36 الجزء" + Page.getGozaName()[17]);
                return;
            case 359:
                toast_show("ثلاثه ارباع الحزب 36 الجزء" + Page.getGozaName()[17]);
                return;
            case 362:
                toast_show("بدايه الحزب 37 الجزء" + Page.getGozaName()[18]);
                return;
            case 364:
                toast_show("ربع الحزب 37 الجزء" + Page.getGozaName()[18]);
                return;
            case 367:
                toast_show("نصف الحزب 37 الجزء" + Page.getGozaName()[18]);
                return;
            case 369:
                toast_show("ثلاثه ارباع الحزب 37 الجزء" + Page.getGozaName()[18]);
                return;
            case 371:
                toast_show("بدايه الحزب 38 الجزء" + Page.getGozaName()[18]);
                return;
            case 374:
                toast_show("ربع الحزب 38 الجزء" + Page.getGozaName()[18]);
                return;
            case 377:
                toast_show("نصف الحزب 38 الجزء" + Page.getGozaName()[18]);
                return;
            case 379:
                toast_show("ثلاثه ارباع الحزب 38 الجزء" + Page.getGozaName()[18]);
                return;
            case 382:
                toast_show("بدايه الحزب 39 الجزء" + Page.getGozaName()[19]);
                return;
            case 384:
                toast_show("ربع الحزب 39 الجزء" + Page.getGozaName()[19]);
                return;
            case 386:
                toast_show("نصف الحزب 39 الجزء" + Page.getGozaName()[19]);
                return;
            case 389:
                toast_show("ثلاثه ارباع الحزب 39 الجزء" + Page.getGozaName()[19]);
                return;
            case 392:
                toast_show("بدايه الحزب 40 الجزء" + Page.getGozaName()[19]);
                return;
            case 394:
                toast_show("ربع الحزب 40 الجزء" + Page.getGozaName()[19]);
                return;
            case 396:
                toast_show("نصف الحزب 40 الجزء" + Page.getGozaName()[19]);
                return;
            case 399:
                toast_show("ثلاثه ارباع الحزب 40 الجزء" + Page.getGozaName()[19]);
                return;
            case 402:
                toast_show("بدايه الحزب 41 الجزء" + Page.getGozaName()[20]);
                return;
            case 404:
                toast_show("ربع الحزب 41 الجزء" + Page.getGozaName()[20]);
                return;
            case 407:
                toast_show("نصف الحزب 41 الجزء" + Page.getGozaName()[20]);
                return;
            case 410:
                toast_show("ثلاثه ارباع الحزب 41 الجزء" + Page.getGozaName()[20]);
                return;
            case 413:
                toast_show("بدايه الحزب 42 الجزء" + Page.getGozaName()[20]);
                return;
            case 415:
                toast_show("ربع الحزب 42 الجزء" + Page.getGozaName()[20]);
                return;
            case 418:
                toast_show("نصف الحزب 42 الجزء" + Page.getGozaName()[20]);
                return;
            case 420:
                toast_show("ثلاثه ارباع الحزب 42 الجزء" + Page.getGozaName()[20]);
                return;
            case 422:
                toast_show("بدايه الحزب 43 الجزء" + Page.getGozaName()[21]);
                return;
            case 425:
                toast_show("ربع الحزب 43 الجزء" + Page.getGozaName()[21]);
                return;
            case 426:
                toast_show("نصف الحزب 43 الجزء" + Page.getGozaName()[21]);
                return;
            case 429:
                toast_show("ثلاثه ارباع الحزب 43 الجزء" + Page.getGozaName()[21]);
                return;
            case 431:
                toast_show("بدايه الحزب 44 الجزء" + Page.getGozaName()[21]);
                return;
            case 433:
                toast_show("ربع الحزب 44 الجزء" + Page.getGozaName()[21]);
                return;
            case 436:
                toast_show("نصف الحزب 44 الجزء" + Page.getGozaName()[21]);
                return;
            case 439:
                toast_show("ثلاثه ارباع الحزب 44 الجزء" + Page.getGozaName()[21]);
                return;
            case 442:
                toast_show("بدايه الحزب 45 الجزء" + Page.getGozaName()[22]);
                return;
            case 444:
                toast_show("ربع الحزب 45 الجزء" + Page.getGozaName()[22]);
                return;
            case 446:
                toast_show("نصف الحزب 45 الجزء" + Page.getGozaName()[22]);
                return;
            case 449:
                toast_show("ثلاثه ارباع الحزب 45 الجزء" + Page.getGozaName()[22]);
                return;
            case 451:
                toast_show("بدايه الحزب 46 الجزء" + Page.getGozaName()[22]);
                return;
            case 454:
                toast_show("ربع الحزب 46 الجزء" + Page.getGozaName()[22]);
                return;
            case 456:
                toast_show("نصف الحزب 46 الجزء" + Page.getGozaName()[22]);
                return;
            case 459:
                toast_show("ثلاثه ارباع الحزب 46 الجزء" + Page.getGozaName()[22]);
                return;
            case 462:
                toast_show("بدايه الحزب 47 الجزء" + Page.getGozaName()[23]);
                return;
            case 464:
                toast_show("ربع الحزب 47 الجزء" + Page.getGozaName()[23]);
                return;
            case 467:
                toast_show("نصف الحزب 47 الجزء" + Page.getGozaName()[23]);
                return;
            case 469:
                toast_show("ثلاثه ارباع الحزب 47 الجزء" + Page.getGozaName()[23]);
                return;
            case 472:
                toast_show("بدايه الحزب 48  الجزء" + Page.getGozaName()[23]);
                return;
            case 474:
                toast_show("ربع الحزب 48 الجزء" + Page.getGozaName()[23]);
                return;
            case 477:
                toast_show("نصف الحزب 48 الجزء" + Page.getGozaName()[23]);
                return;
            case 479:
                toast_show("ثلاثه ارباع الحزب 48 الجزء" + Page.getGozaName()[23]);
                return;
            case 482:
                toast_show("بدايه الحزب 49 الجزء" + Page.getGozaName()[24]);
                return;
            case 484:
                toast_show("ربع الحزب 49 الجزء" + Page.getGozaName()[24]);
                return;
            case 486:
                toast_show("نصف الحزب 49 الجزء" + Page.getGozaName()[24]);
                return;
            case 488:
                toast_show("ثلاثه ارباع الحزب 49 الجزء" + Page.getGozaName()[24]);
                return;
            case 491:
                toast_show("بدايه الحزب 50 الجزء" + Page.getGozaName()[24]);
                return;
            case 493:
                toast_show("ربع الحزب 50 الجزء" + Page.getGozaName()[24]);
                return;
            case 496:
                toast_show("نصف الحزب 50 الجزء" + Page.getGozaName()[24]);
                return;
            case 499:
                toast_show("ثلاثه ارباع الحزب 50 الجزء" + Page.getGozaName()[24]);
                return;
            case 502:
                toast_show("بدايه الحزب 51 الجزء" + Page.getGozaName()[25]);
                return;
            case 505:
                toast_show("ربع الحزب 51 الجزء" + Page.getGozaName()[25]);
                return;
            case 507:
                toast_show("نصف الحزب 51 الجزء" + Page.getGozaName()[25]);
                return;
            case 510:
                toast_show("ثلاثه ارباع الحزب 51 الجزء" + Page.getGozaName()[25]);
                return;
            case 513:
                toast_show("بدايه الحزب 52 الجزء" + Page.getGozaName()[25]);
                return;
            case 515:
                toast_show("ربع الحزب 52 الجزء" + Page.getGozaName()[25]);
                return;
            case 517:
                toast_show("نصف الحزب 52 الجزء" + Page.getGozaName()[25]);
                return;
            case 519:
                toast_show("ثلاثه ارباع الحزب 52 الجزء" + Page.getGozaName()[25]);
                return;
            case 522:
                toast_show("بدايه الحزب 53 الجزء" + Page.getGozaName()[26]);
                return;
            case 524:
                toast_show("ربع الحزب 53 الجزء" + Page.getGozaName()[26]);
                return;
            case 526:
                toast_show("نصف الحزب 53 الجزء" + Page.getGozaName()[26]);
                return;
            case 529:
                toast_show("ثلاثه ارباع الحزب 53 الجزء" + Page.getGozaName()[26]);
                return;
            case 531:
                toast_show("بدايه الحزب 54 الجزء" + Page.getGozaName()[26]);
                return;
            case 534:
                toast_show("ربع الحزب 54 الجزء" + Page.getGozaName()[26]);
                return;
            case 536:
                toast_show("نصف الحزب 54 الجزء" + Page.getGozaName()[26]);
                return;
            case 539:
                toast_show("ثلاثه ارباع الحزب 54 الجزء" + Page.getGozaName()[26]);
                return;
            case 542:
                toast_show("بدايه الحزب 55 الجزء" + Page.getGozaName()[27]);
                return;
            case 544:
                toast_show("ربع الحزب 55 الجزء" + Page.getGozaName()[27]);
                return;
            case 547:
                toast_show("نصف الحزب 55 الجزء" + Page.getGozaName()[27]);
                return;
            case 550:
                toast_show("ثلاثه ارباع الحزب 55 الجزء" + Page.getGozaName()[27]);
                return;
            case 553:
                toast_show("بدايه الحزب 56 الجزء" + Page.getGozaName()[27]);
                return;
            case 554:
                toast_show("ربع الحزب 56 الجزء" + Page.getGozaName()[27]);
                return;
            case 558:
                toast_show("نصف الحزب 56 الجزء" + Page.getGozaName()[27]);
                return;
            case 560:
                toast_show("ثلاثه ارباع الحزب 56 الجزء" + Page.getGozaName()[27]);
                return;
            case 562:
                toast_show("بدايه الحزب 57 الجزء" + Page.getGozaName()[28]);
                return;
            case 564:
                toast_show("ربع الحزب 57 الجزء" + Page.getGozaName()[28]);
                return;
            case 566:
                toast_show("نصف الحزب 57 الجزء" + Page.getGozaName()[28]);
                return;
            case 569:
                toast_show("ثلاثه ارباع الحزب 57 الجزء" + Page.getGozaName()[28]);
                return;
            case 572:
                toast_show("بدايه الحزب 58 الجزء" + Page.getGozaName()[28]);
                return;
            case 575:
                toast_show("ربع الحزب 58 الجزء" + Page.getGozaName()[28]);
                return;
            case 577:
                toast_show("نصف الحزب 58 الجزء" + Page.getGozaName()[28]);
                return;
            case 579:
                toast_show("ثلاثه ارباع الحزب 58 الجزء" + Page.getGozaName()[28]);
                return;
            case 582:
                toast_show("بدايه الحزب 59 الجزء" + Page.getGozaName()[29]);
                return;
            case 585:
                toast_show("ربع الحزب 59 الجزء" + Page.getGozaName()[29]);
                return;
            case 587:
                toast_show("نصف الحزب 59 الجزء" + Page.getGozaName()[29]);
                return;
            case 589:
                toast_show("ثلاثه ارباع الحزب 59 الجزء" + Page.getGozaName()[29]);
                return;
            case 591:
                toast_show("بدايه الحزب 60 الجزء" + Page.getGozaName()[29]);
                return;
            case 594:
                toast_show("ربع الحزب 60 الجزء" + Page.getGozaName()[29]);
                return;
            case 596:
                toast_show("نصف الحزب 60 الجزء" + Page.getGozaName()[29]);
                return;
            case 599:
                toast_show("ثلاثه ارباع الحزب 60 الجزء" + Page.getGozaName()[29]);
                return;

        }
    }

    private void toast_show(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}