package easy.app.base.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SharedPreferenceManager @Inject constructor(
    @ApplicationContext context: Context
) {

    private val preference =
        context.getSharedPreferences(SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE)

    fun contains(key: String): Boolean {
        return preference.contains(key)
    }

    fun get(key: String): String {
        return preference.getString(key, "").orEmpty()
    }

    fun get(key: String, defaultValue: String): String {
        return preference.getString(key, defaultValue) ?: defaultValue
    }

    fun getBooleanValue(key: String, defaultValue: Boolean): Boolean {
        return preference.getBoolean(key, defaultValue)
    }

    fun getIntValue(key: String, defaultValue: Int): Int {
        return preference.getInt(key, defaultValue)
    }

    fun getLongValue(key: String, defaultValue: Long): Long {
        return try {
            preference.getLong(key, defaultValue)
        } catch (e: NumberFormatException) {
            defaultValue
        } catch (e1: ClassCastException) {
            defaultValue
        }
    }

    fun <GenericClass> getObject(
        preferenceKey: String,
        classType: Class<GenericClass>
    ): GenericClass? {
        if (preference.contains(preferenceKey)) {
            return Gson().fromJson(
                preference.getString(
                    preferenceKey,
                    Gson().toJson(classType.newInstance())
                ), classType
            )
        }
        return null
    }

    fun <GenericClass> getObjectArrayList(
        preferenceKey: String,
        classType: Class<GenericClass>
    ): ArrayList<GenericClass> {
        if (preference.contains(preferenceKey)) {
            return try {
                Gson().fromJson(
                    preference.getString(preferenceKey, Gson().toJson(classType.newInstance())),
                    TypeToken.getParameterized(ArrayList::class.java, classType).type
                )
            } catch (e: Exception) {
                arrayListOf()
            }
        }
        return arrayListOf()
    }

    fun getStringArrayList(key: String, defaultValue: ArrayList<String>): ArrayList<String> {
        try {
            val stringSetValue = preference.getStringSet(key, HashSet<String>())
            if (stringSetValue != null && stringSetValue.isNotEmpty()) {
                return ArrayList(stringSetValue)
            }
        } catch (e: Exception) {
            Timber.e(e)
        }
        return defaultValue
    }

    fun put(key: String, value: Any?) {
        preference.edit().putString(key, value.toString()).apply()
    }

    fun <T> putObject(key: String, value: T) {
        preference.edit().putString(key, Gson().toJson(value)).apply()
    }

    fun putStringArrayList(key: String, value: ArrayList<String>) {
        preference.edit().putStringSet(key, HashSet<String>(value)).apply()
    }

    fun putInt(key: String, value: Int) {
        preference.edit().putInt(key, value).apply()
    }

    fun putBoolean(key: String, value: Boolean) {
        preference.edit().putBoolean(key, value).apply()
    }

    fun putBooleanSync(key: String, value: Boolean) {
        preference.edit().putBoolean(key, value).commit()
    }

    fun putLong(key: String, value: Long) {
        preference.edit().putLong(key, value).apply()
    }

    fun putPrimitiveArrayList(key: String, value: ArrayList<Any>) {
        val set: MutableSet<String> = HashSet()
        val arrayList = ArrayList<String>()
        if (!value.isEmpty()) {
            value.forEach {
                arrayList.add(it.toString())
            }
            set.addAll(arrayList)
        }
        preference.edit().putStringSet(key, set).apply()
    }

    fun delete(key: String) {
        preference.edit().remove(key).apply()
    }

    fun deleteAll() {
        preference.edit().clear().apply()
    }


    fun clearSession() {
        // Clear all prefs
        deleteAll()
    }

    companion object {
        const val SHARED_PREFS_FILE_NAME = "find_work_shared_prefs"
    }
}
