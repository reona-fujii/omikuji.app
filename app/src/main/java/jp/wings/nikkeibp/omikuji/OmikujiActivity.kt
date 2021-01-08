package jp.wings.nikkeibp.omikuji

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fortune.*
import kotlinx.android.synthetic.main.omikuji.*

class OmikujiActivity : AppCompatActivity() {
    //おみくじ棚の配列
    val omikujiShelf = Array<OmikujiParts>(20)
    { OmikujiParts(R.drawable.result2, R.string.contents1) }

    //おみくじの保管
    var omikujiNumber = -1


    val omikujiBox = OmikujiBox()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.omikuji)

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val value = pref.getBoolean("button", false)
        button.visibility = if (value) View.VISIBLE else View.INVISIBLE
        omikujiBox.omikujiView = imageView3

        //おみくじ棚の準備
        omikujiShelf[0].drawID = R.drawable.result1
        omikujiShelf[0].fortuneID = R.string.contents2

        omikujiShelf[1].drawID = R.drawable.result3
        omikujiShelf[1].fortuneID = R.string.contents9

        omikujiShelf[2].fortuneID = R.string.contents3
        omikujiShelf[3].fortuneID = R.string.contents4
        omikujiShelf[4].fortuneID = R.string.contents5
        omikujiShelf[5].fortuneID = R.string.contents6
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val toast = Toast.makeText(this, item?.title, Toast.LENGTH_LONG)
        toast.show()
        if (item?.itemId == R.id.item1) {
            val intent = Intent(this, OmikujiPreferenceActivity::class.java)
            startActivity(intent)
        }
        else {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }

    fun onButtonClick(v:View) {
        omikujiBox.shake()
    }
    fun drawResult() {
        //おみくじ番号を取得する
        omikujiNumber = omikujiBox.number

        //おみくじ棚の配列から、omikujiPartsを取得する
        val op = omikujiShelf[omikujiNumber]

        //レイアウトを運勢表示に変更する
        setContentView(R.layout.fortune)

        //画像とテキストを変更する
        imageView.setImageResource(op.drawID)
        textView3.setText(op.fortuneID)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event?.action == MotionEvent.ACTION_DOWN) {
            if (omikujiNumber < 0 && omikujiBox.finish) {
                drawResult()
            }
        }
        return super.onTouchEvent(event)
    }
}