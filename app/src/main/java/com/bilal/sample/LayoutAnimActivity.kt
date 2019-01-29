package com.bilal.sample

import android.animation.LayoutTransition
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.*
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_layout_anim.*

class LayoutAnimActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_anim)


        val mSceneRoot: ViewGroup = findViewById(R.id.scene_root)
        val mAScene: Scene = Scene.getSceneForLayout(mSceneRoot, R.layout.a_scene, this)
        val mAnotherScene: Scene = Scene.getSceneForLayout(mSceneRoot, R.layout.another_scene, this)



        var mFadeTransition: Transition =
                TransitionInflater.from(this)
                        .inflateTransition(R.transition.fade_transition)

        //var fade = Fade(Fade.IN)

        var mFadeTransition2: Transition = Fade()

        TransitionManager.go(mAnotherScene, mFadeTransition2)





        //4.1
        var layoutTransition : LayoutTransition = scene_root.layoutTransition
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        layoutTransition.enableTransitionType(LayoutTransition.APPEARING)
        layoutTransition.enableTransitionType(LayoutTransition.DISAPPEARING)
//        layoutTransition.enableTransitionType(LayoutTransition.CHANGE_APPEARING)
//        layoutTransition.enableTransitionType(LayoutTransition.CHANGE_DISAPPEARING)



    }
}
