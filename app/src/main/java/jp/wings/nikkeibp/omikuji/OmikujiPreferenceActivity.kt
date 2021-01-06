package jp.wings.nikkeibp.omikuji

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class OmikujiPreferenceActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(android.R.id.content, OmikujiPreferenceFragment())
        fragmentTransaction.commit()
        super.onCreate(savedInstanceState)
    }
}