package com.example.androidbook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChapterDetail extends AppCompatActivity {

    TextView chapterTitleText, chapterContentText;

    public static final String PREFS_NAME = "ReadingProgress";
    public static final String KEY_LAST_CHAPTER = "LastChapter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_detail);

        // Initialize views
        chapterTitleText = findViewById(R.id.chapterTitle);
        chapterContentText = findViewById(R.id.chapterContent);

        // Get data from intent
        String chapterTitle = getIntent().getStringExtra("chapterTitle");

        // Set content
        chapterTitleText.setText(chapterTitle);
        chapterContentText.setText(getChapterContent(chapterTitle));

        // Save progress
        saveLastReadChapter(chapterTitle);
    }

    // Save the last read chapter
    private void saveLastReadChapter(String title) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_LAST_CHAPTER, title);
        editor.apply();
    }

    // Dummy content for chapters
    private String getChapterContent(String title) {
        switch (title) {
            case "Chapter 1: Android Studio Setup":
                return "\uD83C\uDFAF Android Studio কি?\n" +
                        "\n" +
                        "Android Studio হলো Google-এর তৈরি একটি Official IDE (Integrated Development Environment), যা Android অ্যাপ ডেভেলপমেন্টের জন্য ব্যবহার হয়। এটি Java, Kotlin, এবং XML ব্যবহার করে Android অ্যাপ তৈরি করতে সাহায্য করে।\n" +
                        "\n" +
                        "\uD83E\uDDF0 Android Studio ইনস্টল ও সেটআপ করার ধাপসমূহ\n" +
                        "✅ ধাপ ১: সিস্টেম রিকোয়ারমেন্টস (System Requirements)\n" +
                        "\n" +
                        "Windows:\n" +
                        "\n" +
                        "OS: Windows 10/11 (64-bit)\n" +
                        "\n" +
                        "RAM: 8 GB+ (সর্বনিম্ন 4GB, কিন্তু 8GB রিকমেন্ডেড)\n" +
                        "\n" +
                        "Disk Space: 8GB+\n" +
                        "\n" +
                        "Resolution: 1280x800 বা তার বেশি\n" +
                        "\n" +
                        "Mac:\n" +
                        "\n" +
                        "macOS 12 বা তার পরবর্তী ভার্সন\n" +
                        "\n" +
                        "8GB RAM+\n" +
                        "\n" +
                        "8GB+ ডিস্ক স্পেস\n" +
                        "\n" +
                        "Linux:\n" +
                        "\n" +
                        "64-bit OS\n" +
                        "\n" +
                        "GNOME/KDE Desktop\n" +
                        "\n" +
                        "8GB RAM+\n" +
                        "\n" +
                        "✅ ধাপ ২: Android Studio ডাউনলোড\n" +
                        "\n" +
                        "\uD83D\uDD17 অফিসিয়াল ওয়েবসাইট: https://developer.android.com/studio\n" +
                        "\n" +
                        "ওয়েবসাইটে যান।\n" +
                        "\n" +
                        "আপনার অপারেটিং সিস্টেম অনুযায়ী (Windows/Mac/Linux) ডাউনলোড বাটনে ক্লিক করুন।\n" +
                        "\n" +
                        "Terms & Conditions accept করে ডাউনলোড করুন।\n" +
                        "\n" +
                        "✅ ধাপ ৩: Android Studio ইনস্টল করা (Windows-এর জন্য)\n" +
                        "\n" +
                        "ডাউনলোড করা .exe ফাইলটি ওপেন করুন।\n" +
                        "\n" +
                        "\"Next\" ক্লিক করুন।\n" +
                        "\n" +
                        "Android Studio এবং Android Virtual Device (AVD) অপশন সিলেক্ট করে আবার Next দিন।\n" +
                        "\n" +
                        "ইনস্টলেশন লোকেশন দিন (ডিফল্ট রাখাই ভালো)।\n" +
                        "\n" +
                        "Install এ ক্লিক করুন।\n" +
                        "\n" +
                        "ইনস্টল শেষ হলে \"Start Android Studio\" সিলেক্ট করে Finish চাপুন।\n" +
                        "\n" +
                        "✅ ধাপ ৪: Android Studio প্রথমবার চালু করা\n" +
                        "\n" +
                        "প্রথমবার চালু করলে এটি জিজ্ঞেস করবে: \"Do you want to import settings?\"\n" +
                        "\n" +
                        "যদি আপনি আগেও ব্যবহার করে থাকেন, তাহলে পুরোনো সেটিংস ইমপোর্ট করতে পারবেন।\n" +
                        "\n" +
                        "নতুন হলে \"Do not import settings\" সিলেক্ট করুন।\n" +
                        "\n" +
                        "Welcome screen আসবে।\n" +
                        "\n" +
                        "✅ ধাপ ৫: SDK এবং Component সেটআপ\n" +
                        "\n" +
                        "Standard ইনস্টলেশন সিলেক্ট করুন।\n" +
                        "\n" +
                        "SDK, Emulator, এবং কিছু প্রয়োজনীয় টুলস ডাউনলোড হবে।\n" +
                        "\n" +
                        "ডাউনলোড ও ইনস্টলেশন শেষ হলে Finish দিন।\n" +
                        "\n" +
                        "✅ ধাপ ৬: প্রথম Android প্রজেক্ট তৈরি করা\n" +
                        "\n" +
                        "\"New Project\" এ ক্লিক করুন।\n" +
                        "\n" +
                        "একটি Template বেছে নিন (যেমন: Empty Activity)।\n" +
                        "\n" +
                        "Project Name, Language (Java/Kotlin), এবং Minimum SDK দিন।\n" +
                        "\n" +
                        "Finish এ ক্লিক করুন।\n" +
                        "\n" +
                        "Gradle Build শেষ হলে আপনি কোড করতে পারবেন।\n" +
                        "\n" +
                        "✅ অতিরিক্ত সেটিংস (Optional but Recommended)\n" +
                        "\uD83D\uDD39 AVD (Android Virtual Device) সেটআপ:\n" +
                        "\n" +
                        "Tools > Device Manager এ যান।\n" +
                        "\n" +
                        "“Create Virtual Device” ক্লিক করুন।\n" +
                        "\n" +
                        "একটি ডিভাইস বেছে নিন (যেমন Pixel 5)।\n" +
                        "\n" +
                        "একটি Android ভার্সন সিলেক্ট করুন (যেমন API 33)।\n" +
                        "\n" +
                        "Finish চাপুন।\n" +
                        "\n" +
                        "এটি Emulator হিসেবে কাজ করবে, আপনি অ্যাপ রান করাতে পারবেন এখানে।\n" +
                        "\n" +
                        "\uD83D\uDEE0 গুরুত্বপূর্ণ সফটওয়্যার\n" +
                        "\n" +
                        "Java Development Kit (JDK): Android Studio নিজেই JDK ইনস্টল করে দেয়। কিন্তু আপনি চাইলে আলাদাভাবে Oracle JDK\n" +
                        " ডাউনলোড করে রাখতে পারেন।\n" +
                        "\n" +
                        "Gradle: Build tool, যা Android Studio তেই থাকে।\n" +
                        "\n" +
                        "❗ সমস্যার সমাধান (Common Issues May Have)\n" +
                        "সমস্যা\tসমাধান\n" +
                        "Slow Emulator\tHAXM ইন্সটল করুন বা Hardware Acceleration চালু করুন\n" +
                        "SDK Not Found\tSDK Location ঠিকভাবে সেট করুন: File > Settings > Appearance & Behavior > System Settings > Android SDK\n" +
                        "Gradle Sync Error\tইন্টারনেট কানেকশন চেক করুন বা Gradle version আপডেট করুন\n" +
                        "\uD83C\uDF93 টিপস\n" +
                        "\n" +
                        "কোডিং শিখতে চান? Html and java দিয়ে শুরু করুন \n" +
                        "\n" +
                        "Emulator ধীরগতির? ফিজিক্যাল ফোন দিয়ে ডিবাগ করুন (USB Debugging অন করে)।\n" +
                        "\n" +
                        "প্র্যাকটিস প্ল্যাটফর্ম: CodeWithMosh\n" +
                        ", [Udemy], [YouTube: freeCodeCamp, Simplified Coding]\n" +
                        "\n" ;
            case "Chapter 2: Android Studio Anatomy":
                return "\uD83E\uDDE9 Android Studio Anatomy\n" +
                        "\n" +
                        "Android Studio হচ্ছে একটি পূর্ণাঙ্গ Android অ্যাপ ডেভেলপমেন্ট টুল, যার বিভিন্ন অংশ আছে। প্রতিটি অংশের নিজস্ব কাজ আছে, যা মিলে একটি সম্পূর্ণ ডেভেলপমেন্ট পরিবেশ তৈরি করে।\n" +
                        "\n" +
                        "\uD83D\uDCCC ১. Project Structure / Project View\n" +
                        "\n" +
                        "\uD83D\uDD39 অবস্থান: বাম পাশে\n" +
                        "\uD83D\uDD39 কাজ:\n" +
                        "\n" +
                        "এখানে আপনার অ্যাপের ফাইল ও ফোল্ডার গুলো থাকে।\n" +
                        "\n" +
                        "app, manifests, java, res ইত্যাদি দেখা যায়।\n" +
                        "\n" +
                        "\uD83D\uDD38 প্রধান ফোল্ডারগুলো:\n" +
                        "\n" +
                        "manifests: AndroidManifest.xml থাকে — এটি অ্যাপের মেইন কনফিগ ফাইল।\n" +
                        "\n" +
                        "java: এখানে সব জাভা/কোটলিন কোড থাকে।\n" +
                        "\n" +
                        "res: Resources (image, layout, strings) রাখা হয়।\n" +
                        "\n" +
                        "gradle scripts: Build configuration ফাইল থাকে।\n" +
                        "\n" +
                        "\uD83D\uDCCC ২. Editor Window\n" +
                        "\n" +
                        "\uD83D\uDD39 অবস্থান: মাঝখানে\n" +
                        "\uD83D\uDD39 কাজ:\n" +
                        "\n" +
                        "আপনি যেখানে কোড লিখেন বা Layout ডিজাইন করেন।\n" +
                        "\n" +
                        "একাধিক ট্যাব একসাথে ওপেন করা যায়।\n" +
                        "\n" +
                        "\uD83D\uDCDD উদাহরণ:\n" +
                        "\n" +
                        "MainActivity.java বা activity_main.xml ওপেন হলে, এই উইন্ডোতেই কাজ করবেন।\n" +
                        "\n" +
                        "\uD83D\uDCCC ৩. Toolbar\n" +
                        "\n" +
                        "\uD83D\uDD39 অবস্থান: উপরের দিকে\n" +
                        "\uD83D\uDD39 কাজ:\n" +
                        "\n" +
                        "দ্রুত অ্যাক্সেসযোগ্য টুলস যেমন Run, Debug, AVD Manager, Build ইত্যাদি থাকে।\n" +
                        "\n" +
                        "\uD83D\uDD18 সাধারণ বাটন:\n" +
                        "\n" +
                        "▶\uFE0F Run: অ্যাপ রান করে\n" +
                        "\n" +
                        "\uD83D\uDC1E Debug: Debug মোডে চালায়\n" +
                        "\n" +
                        "\uD83D\uDCA1 Sync Project with Gradle Files\n" +
                        "\n" +
                        "\uD83D\uDCF1 AVD Manager: Emulator চালু করে\n" +
                        "\n" +
                        "\uD83D\uDCCC ৪. Navigation Bar\n" +
                        "\n" +
                        "\uD83D\uDD39 অবস্থান: Toolbar-এর নিচে\n" +
                        "\uD83D\uDD39 কাজ:\n" +
                        "\n" +
                        "আপনি কোন ফাইল বা ফোল্ডারে আছেন তা দেখায়।\n" +
                        "\n" +
                        "দ্রুত ফাইল Navigate করার জন্য সাহায্য করে।\n" +
                        "\n" +
                        "\uD83D\uDCCC ৫. Tool Windows (ডান/বাম পাশে ছোট ট্যাব)\n" +
                        "\n" +
                        "\uD83D\uDD39 Common Tools:\n" +
                        "\n" +
                        "Logcat: অ্যাপ রান করার সময় লগ (debug info, error) দেখায়।\n" +
                        "\n" +
                        "Build: Build প্রগ্রেস ও ত্রুটি দেখায়।\n" +
                        "\n" +
                        "Terminal: Built-in কমান্ড লাইন টুল।\n" +
                        "\n" +
                        "Event Log: বিভিন্ন event ও warning দেখায়।\n" +
                        "\n" +
                        "\uD83D\uDD39 নিচে থাকা Important Tabs:\n" +
                        "\n" +
                        "Tab\tকাজ\n" +
                        "Logcat\tRuntime log দেখা যায়\n" +
                        "Build\tBuild status দেখা যায়\n" +
                        "Terminal\tTerminal/Command prompt\n" +
                        "Profiler\tPerformance monitor করা যায়\n" +
                        "Emulator\tEmulator চলতে পারে এখানেই\n" +
                        "\uD83D\uDCCC ৬. Layout Editor (Design UI for App)\n" +
                        "\n" +
                        "\uD83D\uDD39 অবস্থান: XML ফাইল ওপেন করলে\n" +
                        "\uD83D\uDD39 দুইটি মোড:\n" +
                        "\n" +
                        "Code Mode: XML কোড এডিট করা যায়\n" +
                        "\n" +
                        "Design Mode: Drag and drop করে UI ডিজাইন করা যায়\n" +
                        "\n" +
                        "\uD83D\uDD38 Tools:\n" +
                        "\n" +
                        "Palette: Component (Button, TextView) টেনে এনে ব্যবহার করা যায়\n" +
                        "\n" +
                        "Attributes: UI উপাদানের বৈশিষ্ট্য (color, size, margin) নির্ধারণ\n" +
                        "\n" +
                        "\uD83D\uDCCC ৭. Gradle (Build System)\n" +
                        "\n" +
                        "\uD83D\uDD39 কাজ:\n" +
                        "\n" +
                        "অ্যাপ কম্পাইল ও বিল্ড করতে ব্যবহার হয়\n" +
                        "\n" +
                        "ডিপেনডেন্সি ম্যানেজ করে\n" +
                        "\n" +
                        "প্রজেক্টের কনফিগারেশন ফাইল হিসেবে কাজ করে\n" +
                        "\n" +
                        "\uD83D\uDD38 গুরুত্বপূর্ণ Gradle ফাইল:\n" +
                        "\n" +
                        "build.gradle (Project level)\n" +
                        "\n" +
                        "build.gradle (App level)\n" +
                        "\n" +
                        "gradle.properties\n" +
                        "\n" +
                        "\uD83D\uDCCC ৮. AVD Manager (Android Virtual Device)\n" +
                        "\n" +
                        "\uD83D\uDD39 অবস্থান: Toolbar এ ফোন আইকন \uD83D\uDCF1\n" +
                        "\uD83D\uDD39 কাজ:\n" +
                        "\n" +
                        "Emulator তৈরি ও চালানোর জন্য\n" +
                        "\n" +
                        "আপনি যদি ফিজিক্যাল ফোন ব্যবহার না করেন, তবে এখানে ভার্চুয়াল ফোন রান করতে পারবেন।\n" +
                        "\n" +
                        "\uD83D\uDCCC ৯. Run/Debug Configurations\n" +
                        "\n" +
                        "\uD83D\uDD39 অবস্থান: Toolbar-এর ডান দিকে\n" +
                        "\uD83D\uDD39 কাজ:\n" +
                        "\n" +
                        "কোন মোডে (Run, Debug) অ্যাপ চালানো হবে তা নির্ধারণ করে।\n" +
                        "\n" +
                        "কোন ডিভাইসে চলবে, কোন অ্যাকটিভিটি ওপেন হবে, ইত্যাদি ঠিক করা যায়।\n" +
                        "\n" +
                        "\uD83D\uDCCC ১০. Inspector Tools (Advanced)\n" +
                        "\n" +
                        "\uD83D\uDD38 শুধুমাত্র বুঝে ব্যবহার করলে ভালো:\n" +
                        "\n" +
                        "Layout Inspector: UI Render কেমন দেখাচ্ছে তা লাইভ ভিউতে দেখতে পারবেন।\n" +
                        "\n" +
                        "Database Inspector: App-এর লাইভ ডেটাবেস দেখতে পারবেন।\n" +
                        "\n" +
                        "Network Inspector: App-এর নেটওয়ার্ক রিকোয়েস্ট মনিটর করতে পারবেন।\n" +
                        "\n" +
                        "\uD83E\uDDE0 সংক্ষেপে Android Studio-এর Anatomy:\n" +
                        "অংশ\tকাজ\n" +
                        "Project View\tফাইল ব্রাউজিং\n" +
                        "Editor Window\tকোড/ডিজাইন লেখা\n" +
                        "Toolbar\tকমন টুলস (Run, Debug)\n" +
                        "Tool Windows\tLog, Build, Terminal\n" +
                        "Layout Editor\tUI ডিজাইন\n" +
                        "Gradle\tBuild system\n" +
                        "AVD Manager\tEmulator চালানো\n" +
                        "Logcat\tRuntime লগ দেখা\n" +
                        "Profiler\tApp performance দেখানো\n" +
                        "\uD83D\uDCDD উপসংহার\n" +
                        "\n" +
                        "Android Studio অনেক ফিচার সমৃদ্ধ একটি IDE। এর প্রতিটি অংশ আপনি যত বেশি বুঝবেন, অ্যাপ ডেভেলপমেন্ট তত সহজ হবে। আপনি নতুন হলে শুরুতে শুধু নিচের অংশগুলো ভালোভাবে বুঝুন:\n" +
                        "\n" +
                        "Project Structure\n" +
                        "\n" +
                        "Editor Window\n" +
                        "\n" +
                        "Layout Editor\n" +
                        "\n" +
                        "Logcat\n" +
                        "\n" +
                        "AVD Manager";
            case "Chapter 3: UI Layouts":
                return "### Chapter 3: UI Layouts\n\n" +
                        "In this chapter, we'll dive into Android's powerful layout system:\n" +
                        "- **LinearLayout**: Arrange views vertically or horizontally; understand `weight` for flexible space.\n" +
                        "- **RelativeLayout**: Position views relative to each other or their parent container.\n" +
                        "- **ConstraintLayout**: Modern and flexible layout for complex UIs with performance benefits.\n" +
                        "- **Tips for responsiveness**: Density-independent pixels (dp), screen size buckets, and usage of `?attr`.\n\n" +
                        "By mastering layouts, you’ll design UIs that adapt beautifully across devices.";

            case "Chapter 4: Activities and Intents":
                return "Learn how Android Activities work and how to navigate using Intents.";
            case "Chapter 5: Views and Widgets":
                return "Explore Buttons, TextViews, EditTexts, and custom views.";
            case "Chapter 6: RecyclerView":
                return "Implement scrollable lists using RecyclerView and adapters.";
            case "Chapter 7: Data Storage":
                return "Understand SharedPreferences, SQLite, and Room database.";
            case "Chapter 8: Networking":
                return "Learn to make HTTP requests, handle JSON, and use Retrofit.";
            case "Chapter 9: Final Project":
                return "Put your knowledge to the test by building a full Android app.";
            default:
                return "Content not available for this chapter.";
        }
    }
}
