package com.iambedant.instantappstarter.injection.components;

import com.iambedant.instantappstarter.injection.PerFragment;
import com.iambedant.instantappstarter.injection.modules.FragmentModule;

import dagger.Subcomponent;

/**
 * Created by @iamBedant on 12/08/17.
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

}

