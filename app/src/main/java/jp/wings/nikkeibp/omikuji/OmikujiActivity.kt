package jp.wings.nikkeibp.omikuji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.main.*
import java.util.*

class OmikujiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val rnd = Random()
        val number = rnd.nextInt(20)

        //おみくじ棚の準備
        val omikujiShelf = Arrary<String>(20, {"吉"})
        omikujiShelf[0] = "大吉"
        omikujiShelf[19] = "凶"
        val str = omikujiShelf[number]
        hello_view.text = str
    }
}