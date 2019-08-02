package com.lyhoangvinh.simple.di.module

import com.lyhoangvinh.simple.ui.features.avg.AgvActivity
import com.lyhoangvinh.simple.ui.features.avg.AgvActivityModule
import com.lyhoangvinh.simple.ui.features.avg.home.HomeFragment
import com.lyhoangvinh.simple.ui.features.avg.home.HomeFragmentModule
import com.lyhoangvinh.simple.ui.features.avg.home.adapter.inside.BannerImagesFragment
import com.lyhoangvinh.simple.ui.features.avg.home.adapter.inside.BannerImagesModule
import com.lyhoangvinh.simple.ui.features.comic.testactivity.ComicActivity
import com.lyhoangvinh.simple.ui.features.comic.testactivity.ComicActivityModule
import com.lyhoangvinh.simple.ui.features.comic.testfragment.ComicFragment
import com.lyhoangvinh.simple.ui.features.comic.testfragment.ComicFragmentModule
import com.lyhoangvinh.simple.ui.features.comic.testfragment.ComicSingleActivity
import com.lyhoangvinh.simple.ui.features.comic.testfragment.ComicSingleActivityModule
import com.lyhoangvinh.simple.ui.features.comic.testpaging.ComicPagingActivity
import com.lyhoangvinh.simple.ui.features.comic.testpaging.ComicPagingActivityModule
import com.lyhoangvinh.simple.ui.features.splash.SplashActivity
import com.lyhoangvinh.simple.ui.features.splash.SplashModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [ComicActivityModule::class])
    abstract fun comicActivity(): ComicActivity

    @ContributesAndroidInjector(modules = [ComicSingleActivityModule::class])
    abstract fun comicSingleActivity(): ComicSingleActivity

    @ContributesAndroidInjector(modules = [ComicFragmentModule::class])
    abstract fun comicFragmentFragment(): ComicFragment

    @ContributesAndroidInjector(modules = [AgvActivityModule::class])
    abstract fun avgActivity(): AgvActivity

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun homeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun splashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [ComicPagingActivityModule::class])
    abstract fun comicPagingActivity(): ComicPagingActivity

    @ContributesAndroidInjector(modules = [BannerImagesModule::class])
    abstract fun bannerImagesFragment(): BannerImagesFragment
}