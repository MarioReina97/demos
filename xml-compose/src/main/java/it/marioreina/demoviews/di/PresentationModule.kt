package it.marioreina.demoviews.di

import it.marioreina.demoviews.deal.DealViewModel
import it.marioreina.demoviews.domain.di.getDomainModule
import it.marioreina.demoviews.firstaccess.FirstAccessViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun getPresentationModule(): List<Module> {

    val presentationModule = module {
        viewModel { DealViewModel(get(), get(), get()) }
        viewModel { FirstAccessViewModel(get()) }
    }
    return presentationModule + getDomainModule()
}