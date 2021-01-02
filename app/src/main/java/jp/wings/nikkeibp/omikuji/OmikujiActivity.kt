package jp.wings.nikkeibp.omikuji

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.omikuji.*

class OmikujiActivity : AppCompatActivity() {
    val omikujiBox = OmikujiBox()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.omikuji)
        omikujiBox.omikujiView = imageView3


/*
        val rnd = Random()
        val number = rnd.nextInt(20)

        //おみくじ棚の準備
        val omikujiShelf = Arrary<String>(20, {"吉"})
        omikujiShelf[0] = "大吉"
        omikujiShelf[19] = "凶"
        val str = omikujiShelf[number]
        hello_view.text = str

 */
    }
    fun onButtonClick(v:View) {
        omikujiBox.shake()
//        val translate = TranslateAnimation(0f, 0f, 0f, -200f)
//        translate.repeatMode = Animation.REVERSE
//        translate.repeatCount = 5
//        translate.duration = 100
//
//        val rotate = RotateAnimation(0f, -36f, imageView3.width/2f, imageView3.height/2f)
//        rotate.duration = 200
//
//        val set = AnimationSet(true)
//        set.addAnimation(rotate)
//        set.addAnimation(translate)
//
//
//
//        imageView3.startAnimation(set)
//        imageView3.setImageResource(R.drawable.result1)
    }
}