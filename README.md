# Motion Xmple 🚀

[![Say Thanks!](https://img.shields.io/badge/Say%20Thanks-!-1EAEDB.svg)](https://saythanks.io/to/adityasonel)

```
The alternative to good design is always bad design.
There is no such thing as no design.

-Adam Judge
```

The first and foremost thing that directly proportional to user's hapiness is software/application design. By keeping this in mind I created this repository. To showcase various design implementations from dribbble, behance, my imaginations and sometimes from an released application designs.

All animations/transitions in this repo are developed with android framework mechanisms such as,

* [Animated Vector Drawable](https://developer.android.com/guide/topics/graphics/drawable-animation)
* [Property Animation](https://developer.android.com/guide/topics/graphics/prop-animation)
* [LayoutTransition](https://developer.android.com/reference/android/animation/LayoutTransition)
* [Animate layout changes using a transition](https://developer.android.com/training/transitions/)
* [CoordinatorLayout](https://developer.android.com/reference/android/support/design/widget/CoordinatorLayout)

And the last but not least,

* [MotionLayout](https://developer.android.com/reference/android/support/constraint/motion/MotionLayout)

Motion Layout is nothing but updated ConstraintLayout that allows to animate layout between various states. MotionLayout is my personal favorite mechanism for animate layouts.

## What's inside

* Alpha (OnBoarding)

This is an simple onboarding animation/transition. Developed with android native component viewpager. Gradient Drawable is used in background and with help of `ViewPager.addOnPageChangeListener` performing changing in color on scroll of ViewPager. ` ViewPager.setPageTransformer` method are also very usefull for creating parallax effect as shown in below screenshot.


<img src="https://github.com/adityasonel/motionxmple/blob/master/ss/alpha.gif" width="220" height="380" />

* Beta (OnBoarding)

Below onboarding can't be possible without [SparkleMotion](https://github.com/IFTTT/SparkleMotion), this repo is deprecated now but the code is never be too old to use.

<img src="https://github.com/adityasonel/motionxmple/blob/master/ss/beta.gif" width="220" height="380" />

* [Tubik's Material Design](https://dribbble.com/shots/4575035-Playing-with-Updated-Material-Design)

Credits for this design all goes to Tubik, check more designs https://dribbble.com/Tubik. This animations is all implemented with the help of Motion Layout. This is goog example to understand MotionLayout working.

<img src="https://github.com/adityasonel/motionxmple/blob/master/ss/tubik.gif" width="220" height="380" />

## Questions? 🤔

Hit me on

[![Twitter](https://img.shields.io/badge/Twitter-%40heisen_brg-blue.svg)](https://twitter.com/heisen_brg)
[![Linkedin](https://img.shields.io/badge/Linkedin-%40AdityaSonel-blue.svg)](www.linkedin.com/in/aditya-sonel)

## License

[MIT License](LICENSE)