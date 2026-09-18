# Proguard rules for Nostalgia Reader
-keep class com.nostalgia.reader.model.** { *; }
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}
