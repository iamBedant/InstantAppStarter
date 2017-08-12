
package com.iambedant.instantappstarter.data;

import com.iambedant.instantappstarter.data.local.pref.PreferencesHelper;
import com.iambedant.instantappstarter.data.remote.ApiHelper;

public interface DataManager extends PreferencesHelper, ApiHelper {

  void setUserAsLoggedOut();

}
