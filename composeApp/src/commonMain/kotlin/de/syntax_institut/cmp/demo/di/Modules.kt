package de.syntax_institut.cmp.demo.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import de.syntax_institut.cmp.demo.data.local.DatabaseFactory
import de.syntax_institut.cmp.demo.data.local.MealDatabase
import de.syntax_institut.cmp.demo.data.remote.HttpClientFactory
import de.syntax_institut.cmp.demo.data.remote.MealApi
import de.syntax_institut.cmp.demo.data.remote.MealApiService
import de.syntax_institut.cmp.demo.data.repository.DefaultMealRepository
import de.syntax_institut.cmp.demo.data.repository.MealRepository
import de.syntax_institut.cmp.demo.ui.MealViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
   single { HttpClientFactory.create(get()) }
   singleOf(::MealApi).bind<MealApiService>()
   singleOf(::DefaultMealRepository).bind<MealRepository>()

   single {
      get<DatabaseFactory>().create()
         .setDriver(BundledSQLiteDriver())
         .build()
   }
   single { get<MealDatabase>().mealDao }

   viewModelOf(::MealViewModel)
}