package com.abt.animation.activity

import android.os.Bundle
import android.support.animation.DynamicAnimation
import android.support.animation.FlingAnimation
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce
import android.support.v7.app.AppCompatActivity
import com.abt.animation.R
import kotlinx.android.synthetic.main.activity_physics_view.*

class PhysicsAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics_view)

        var velocity = 500f
        btnFling.text = "Fling"
        btnFling.setOnClickListener {
            val flingAnimation = FlingAnimation(image, DynamicAnimation.X)
            flingAnimation.setStartVelocity(velocity)
            flingAnimation.friction = 0.1f
            flingAnimation.start()
            velocity = -velocity
        }

        btnSpring.setOnClickListener {
            val springAnimation = SpringAnimation(image, DynamicAnimation.Y)
            springAnimation.setStartValue(500f)

            val springForce = SpringForce()
            springForce.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
            springForce.stiffness = SpringForce.STIFFNESS_LOW
            springForce.finalPosition = image.y

            springAnimation.spring = springForce
            springAnimation.start()
        }
    }
}
