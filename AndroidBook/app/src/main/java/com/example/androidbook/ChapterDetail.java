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
                return "" +
                        "📘 **Chapter 1: Android Studio Setup**\n\n" +

                        "🎯 **Android Studio কি?**\n" +
                        "Android Studio হলো Google-এর তৈরি একটি Official IDE (Integrated Development Environment), যা Android অ্যাপ ডেভেলপমেন্টের জন্য ব্যবহার হয়। এটি Java, Kotlin, এবং XML ব্যবহার করে Android অ্যাপ তৈরি করতে সাহায্য করে।\n\n" +

                        "🧩 **ইনস্টল ও সেটআপ ধাপসমূহ**\n\n" +

                        "✅ **ধাপ ১: সিস্টেম রিকোয়ারমেন্টস (System Requirements)**\n\n" +
                        "💻 **Windows:**\n" +
                        "- OS: Windows 10/11 (64-bit)\n" +
                        "- RAM: 8 GB+ (সর্বনিম্ন 4GB, কিন্তু 8GB রিকমেন্ডেড)\n" +
                        "- Disk Space: 8GB+\n" +
                        "- Resolution: 1280x800 বা তার বেশি\n\n" +

                        "🍎 **Mac:**\n" +
                        "- macOS 12 বা পরবর্তী ভার্সন\n" +
                        "- RAM: 8 GB+\n" +
                        "- Disk Space: 8GB+\n\n" +

                        "🐧 **Linux:**\n" +
                        "- 64-bit OS\n" +
                        "- GNOME/KDE Desktop\n" +
                        "- RAM: 8 GB+\n\n" +

                        "✅ **ধাপ ২: Android Studio ডাউনলোড**\n" +
                        "🔗 অফিসিয়াল ওয়েবসাইট: https://developer.android.com/studio\n" +
                        "- ওয়েবসাইটে যান\n" +
                        "- আপনার OS অনুযায়ী (Windows/Mac/Linux) ডাউনলোড করুন\n" +
                        "- Terms & Conditions accept করুন\n\n" +

                        "✅ **ধাপ ৩: ইনস্টলেশন (Windows)**\n" +
                        "1. ডাউনলোড করা `.exe` ফাইল ওপেন করুন\n" +
                        "2. \"Next\" ক্লিক করুন\n" +
                        "3. **Android Studio** এবং **AVD (Android Virtual Device)** সিলেক্ট করুন\n" +
                        "4. Install লোকেশন দিন (Default রাখা ভালো)\n" +
                        "5. Install > Finish > \"Start Android Studio\"\n\n" +

                        "✅ **ধাপ ৪: প্রথমবার চালু করা**\n" +
                        "- জিজ্ঞেস করবে: *Do you want to import settings?*\n" +
                        "- আগে ব্যবহার করলে পুরোনো সেটিংস ইমপোর্ট করুন\n" +
                        "- নতুন হলে \"Do not import settings\" সিলেক্ট করুন\n\n" +

                        "✅ **ধাপ ৫: SDK & Components সেটআপ**\n" +
                        "- Standard ইনস্টলেশন সিলেক্ট করুন\n" +
                        "- SDK, Emulator ও প্রয়োজনীয় টুলস ডাউনলোড হবে\n" +
                        "- শেষ হলে *Finish* ক্লিক করুন\n\n" +

                        "✅ **ধাপ ৬: প্রথম প্রজেক্ট তৈরি করা**\n" +
                        "1. *New Project* → Template (Empty Activity)\n" +
                        "2. Project Name, Language (Java/Kotlin), Minimum SDK দিন\n" +
                        "3. *Finish* চাপুন\n" +
                        "4. Gradle Build শেষ হলে কোড লেখা শুরু করতে পারবেন\n\n" +

                        "⚙️ **অতিরিক্ত সেটিংস (Optional but Recommended)**\n" +
                        "🔹 **AVD (Android Virtual Device) সেটআপ:**\n" +
                        "- Tools > Device Manager → *Create Virtual Device*\n" +
                        "- Device (Pixel 5) → Android ভার্সন (API 33)\n" +
                        "- Finish\n" +
                        "👉 এখন Emulator-এ অ্যাপ রান করাতে পারবেন\n\n" +

                        "🛠 **গুরুত্বপূর্ণ সফটওয়্যার**\n" +
                        "- Java Development Kit (JDK): Android Studio-র সাথে আসে, চাইলে আলাদা ইনস্টল করা যাবে\n" +
                        "- Gradle: Build tool (Android Studio তে ডিফল্টভাবে থাকে)\n\n" +

                        "❗ **Common Issues & Solutions**\n" +
                        "সমস্যা | সমাধান\n" +
                        "-------|-------------------------------\n" +
                        "Slow Emulator | HAXM ইনস্টল করুন বা Hardware Acceleration চালু করুন\n" +
                        "SDK Not Found | File > Settings > SDK Location ঠিক করুন\n" +
                        "Gradle Sync Error | ইন্টারনেট চেক করুন বা Gradle আপডেট করুন\n\n" +

                        "🎓 **টিপস**\n" +
                        "- কোডিং শিখতে চান? *HTML & Java দিয়ে শুরু করুন*\n" +
                        "- Emulator ধীর? ফিজিক্যাল ফোন দিয়ে USB Debugging ব্যবহার করুন\n" +
                        "- প্র্যাকটিস প্ল্যাটফর্ম: [CodeWithMosh], [Udemy], [YouTube: freeCodeCamp, Simplified Coding]\n\n";

            case "Chapter 2: Android Studio Anatomy":
                return "" +
                        "🧩 **Chapter 2: Android Studio Anatomy**\n\n" +

                        "Android Studio হলো একটি পূর্ণাঙ্গ Android অ্যাপ ডেভেলপমেন্ট টুল, যার বিভিন্ন অংশ আছে। প্রতিটি অংশের নিজস্ব কাজ আছে, যা মিলে একটি সম্পূর্ণ ডেভেলপমেন্ট পরিবেশ তৈরি করে।\n\n" +

                        "📌 **১. Project Structure / Project View**\n" +
                        "📍 অবস্থান: বাম পাশে\n" +
                        "📍 কাজ: অ্যাপের ফাইল ও ফোল্ডার ম্যানেজ করা\n\n" +
                        "🔹 প্রধান ফোল্ডারগুলো:\n" +
                        "- **manifests:** `AndroidManifest.xml` (অ্যাপের মূল কনফিগ ফাইল)\n" +
                        "- **java:** সব Java/Kotlin কোড\n" +
                        "- **res:** Resources (images, layouts, strings)\n" +
                        "- **gradle scripts:** Build configuration ফাইল\n\n" +

                        "📌 **২. Editor Window**\n" +
                        "📍 অবস্থান: মাঝখানে\n" +
                        "📍 কাজ: কোড লেখা বা Layout ডিজাইন করা\n\n" +
                        "📝 উদাহরণ: `MainActivity.java` বা `activity_main.xml`\n" +
                        "👉 একাধিক ট্যাব একসাথে ওপেন করা যায়\n\n" +

                        "📌 **৩. Toolbar**\n" +
                        "📍 অবস্থান: উপরে\n" +
                        "📍 কাজ: দ্রুত অ্যাক্সেসযোগ্য টুলস (Run, Debug, Build)\n\n" +
                        "✨ সাধারণ বাটন:\n" +
                        "- ▶️ **Run:** অ্যাপ চালানো\n" +
                        "- 🐞 **Debug:** Debug মোডে চালানো\n" +
                        "- 💡 **Sync Project with Gradle Files**\n" +
                        "- 📱 **AVD Manager:** Emulator চালু করা\n\n" +

                        "📌 **৪. Navigation Bar**\n" +
                        "📍 অবস্থান: Toolbar-এর নিচে\n" +
                        "📍 কাজ: কোন ফাইল বা ফোল্ডারে আছেন তা দেখানো এবং দ্রুত Navigate করতে সাহায্য করে\n\n" +

                        "📌 **৫. Tool Windows (Side Tabs)**\n" +
                        "📍 অবস্থান: ডান/বাম পাশে\n" +
                        "📍 Common Tools:\n" +
                        "- **Logcat:** অ্যাপ রান করার সময় debug info & error\n" +
                        "- **Build:** Build প্রগ্রেস ও error\n" +
                        "- **Terminal:** Built-in কমান্ড লাইন\n" +
                        "- **Event Log:** Event & warning\n\n" +

                        "📌 **নিচে থাকা Important Tabs:**\n" +
                        "Tab | কাজ\n" +
                        "----|--------------------------------\n" +
                        "Logcat | Runtime log দেখা যায়\n" +
                        "Build | Build status দেখা যায়\n" +
                        "Terminal | Command/Terminal access\n" +
                        "Profiler | Performance monitor\n" +
                        "Emulator | Emulator রান করা যায়\n\n" +

                        "📌 **৬. Layout Editor (UI Designer)**\n" +
                        "📍 অবস্থান: XML ফাইল ওপেন করলে\n" +
                        "📍 মোড: \n" +
                        "- **Code Mode:** XML কোড এডিট\n" +
                        "- **Design Mode:** Drag & drop UI design\n\n" +
                        "🔹 Tools:\n" +
                        "- **Palette:** Button, TextView ইত্যাদি টেনে আনা যায়\n" +
                        "- **Attributes:** UI বৈশিষ্ট্য (color, margin, size)\n\n" +

                        "📌 **৭. Gradle (Build System)**\n" +
                        "📍 কাজ:\n" +
                        "- অ্যাপ compile ও build করা\n" +
                        "- Dependencies ম্যানেজ করা\n" +
                        "- Project configuration নির্ধারণ করা\n\n" +
                        "🔹 গুরুত্বপূর্ণ Gradle ফাইল:\n" +
                        "- `build.gradle` (Project level)\n" +
                        "- `build.gradle` (App level)\n" +
                        "- `gradle.properties`\n\n" +

                        "📌 **৮. AVD Manager (Android Virtual Device)**\n" +
                        "📍 অবস্থান: Toolbar → 📱 আইকন\n" +
                        "📍 কাজ: Emulator তৈরি ও চালানো\n" +
                        "👉 ফিজিক্যাল ফোন ছাড়াই অ্যাপ রান করা যায়\n\n" +

                        "📌 **৯. Run/Debug Configurations**\n" +
                        "📍 অবস্থান: Toolbar-এর ডান দিকে\n" +
                        "📍 কাজ:\n" +
                        "- Run বা Debug মোড নির্বাচন করা\n" +
                        "- কোন ডিভাইসে রান হবে নির্ধারণ করা\n" +
                        "- কোন Activity ওপেন হবে সেট করা\n\n" +

                        "📌 **১০. Inspector Tools (Advanced)**\n" +
                        "🔹 Layout Inspector: UI live render দেখা\n" +
                        "🔹 Database Inspector: Live database দেখা\n" +
                        "🔹 Network Inspector: নেটওয়ার্ক রিকোয়েস্ট মনিটর করা\n\n" +

                        "🧠 **সংক্ষেপে Android Studio Anatomy:**\n" +
                        "অংশ | কাজ\n" +
                        "----|---------------------------\n" +
                        "Project View | ফাইল ব্রাউজিং\n" +
                        "Editor Window | কোড/ডিজাইন\n" +
                        "Toolbar | কমন টুলস\n" +
                        "Tool Windows | Log, Build, Terminal\n" +
                        "Layout Editor | UI ডিজাইন\n" +
                        "Gradle | Build system\n" +
                        "AVD Manager | Emulator চালানো\n" +
                        "Logcat | Runtime log\n" +
                        "Profiler | Performance monitor\n\n" +

                        "📝 **উপসংহার:**\n" +
                        "Android Studio অনেক ফিচার সমৃদ্ধ IDE। নতুনদের জন্য প্রথমে শুধু নিচের অংশগুলো ভালোভাবে শিখুন:\n" +
                        "- Project Structure\n" +
                        "- Editor Window\n" +
                        "- Layout Editor\n" +
                        "- Logcat\n" +
                        "- AVD Manager\n\n";

            case "Chapter 3: UI Layouts":
                return "`### Chapter 3: UI Layouts\n" +
                        "\n" +
                        "অ্যান্ড্রয়েড অ্যাপ ডেভেলপমেন্টে **UI Layouts** একটি গুরুত্বপূর্ণ অংশ। আপনি যদি নতুন ডেভেলপার হন, তাহলে UI Layouts সম্পর্কে পরিষ্কার ধারণা থাকা খুব জরুরি। নিচে বাংলায় Android UI Layouts বিস্তারিত আলোচনা করা হলো।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## \uD83D\uDD30 UI Layouts কী? (What is UI Layout?)\n" +
                        "\n" +
                        "UI Layout হলো অ্যাপ্লিকেশনের ইউজার ইন্টারফেস (UI) এর কাঠামো বা গঠন। আপনি যেসব UI উপাদান যেমন \\`Button\\`, \\`TextView\\`, \\`ImageView\\` ইত্যাদি অ্যাপের স্ক্রিনে দেখেন, সেগুলো কীভাবে সাজানো হবে তা Layout দ্বারা নির্ধারিত হয়।\n" +
                        "\n" +
                        "\uD83D\uDCC1 XML ফাইল ব্যবহার করে Layout গুলো তৈরি করা হয় (যেমন \\`activity_main.xml\\`)।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## \uD83E\uDD31 Android Layout এর ধরণ (Types of Layouts)\n" +
                        "\n" +
                        "### 1\uFE0F⃣ **LinearLayout (লিনিয়ার লেআউট)**\n" +
                        "\n" +
                        "* উপাদানগুলোকে **এক লাইনে** সাজায়।\n" +
                        "* দুই ধরনের Orientation:\n" +
                        "  * \\`android:orientation=\"vertical\"\\` → উপরে-নিচে\n" +
                        "  * \\`android:orientation=\"horizontal\"\\` → বাম-ডানে\n" +
                        "* সোজা ও সহজ লেআউট ডিজাইনের জন্য উপযোগী।\n" +
                        "\n" +
                        "\uD83D\uDCDD উদাহরণ:\n" +
                        "\n" +
                        "\\`\\`\\`xml\n" +
                        "<LinearLayout\n" +
                        "    android:orientation=\"vertical\"\n" +
                        "    android:layout_width=\"match_parent\"\n" +
                        "    android:layout_height=\"match_parent\">\n" +
                        "\n" +
                        "    <TextView\n" +
                        "        android:text=\"স্বাগতম\"\n" +
                        "        android:layout_width=\"wrap_content\"\n" +
                        "        android:layout_height=\"wrap_content\"/>\n" +
                        "\n" +
                        "    <Button\n" +
                        "        android:text=\"চাপ দিন\"\n" +
                        "        android:layout_width=\"wrap_content\"\n" +
                        "        android:layout_height=\"wrap_content\"/>\n" +
                        "\n" +
                        "</LinearLayout>\n" +
                        "\\`\\`\\`\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "### 2\uFE0F⃣ **RelativeLayout (রিলেটিভ লেআউট)**\n" +
                        "\n" +
                        "* ভিউগুলোকে একে অপরের আপেক্ষিক অবস্থানে রাখে।\n" +
                        "* কোন ভিউকে অন্য ভিউর উপরে, নিচে, ডানে বা বামে রাখা যায়।\n" +
                        "\n" +
                        "\uD83D\uDCDD উদাহরণ:\n" +
                        "\n" +
                        "\\`\\`\\`xml\n" +
                        "<RelativeLayout\n" +
                        "    android:layout_width=\"match_parent\"\n" +
                        "    android:layout_height=\"match_parent\">\n" +
                        "\n" +
                        "    <TextView\n" +
                        "        android:id=\"@+id/text1\"\n" +
                        "        android:text=\"টেক্সট\"\n" +
                        "        android:layout_width=\"wrap_content\"\n" +
                        "        android:layout_height=\"wrap_content\" />\n" +
                        "\n" +
                        "    <Button\n" +
                        "        android:text=\"চাপ দিন\"\n" +
                        "        android:layout_width=\"wrap_content\"\n" +
                        "        android:layout_height=\"wrap_content\"\n" +
                        "        android:layout_below=\"@id/text1\"/>\n" +
                        "\n" +
                        "</RelativeLayout>\n" +
                        "\\`\\`\\`\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "### 3\uFE0F⃣ **ConstraintLayout (কনস্ট্রেইন্ট লেআউট)**\n" +
                        "\n" +
                        "* আধুনিক এবং সবচেয়ে শক্তিশালী Layout।\n" +
                        "* ভিউদের মধ্যে Constraint (নিয়ম) তৈরি করে সম্পর্ক স্থাপন করে।\n" +
                        "* Nested Layout এর দরকার হয় না → পারফরম্যান্স ভালো থাকে।\n" +
                        "\n" +
                        "\uD83D\uDCDD বৈশিষ্ট্য:\n" +
                        "\n" +
                        "* UI উপাদানগুলো একে অপরের সাথে এবং প্যারেন্টের সাথে Constraint ব্যবহার করে সাজানো যায়।\n" +
                        "* জটিল Layout সহজে তৈরি করা যায়।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "### 4\uFE0F⃣ **FrameLayout (ফ্রেম লেআউট)**\n" +
                        "\n" +
                        "* একটি ফ্রেমের মধ্যে একাধিক ভিউ থাকে।\n" +
                        "* সাধারণত একটার উপরে আরেকটা ভিউ রাখা হয় (overlay effect)।\n" +
                        "* সিম্পল UI বা Background/foreground এর জন্য ব্যবহৃত হয়।\n" +
                        "\n" +
                        "\uD83D\uDCDD উদাহরণ:\n" +
                        "\n" +
                        "\\`\\`\\`xml\n" +
                        "<FrameLayout\n" +
                        "    android:layout_width=\"match_parent\"\n" +
                        "    android:layout_height=\"match_parent\">\n" +
                        "\n" +
                        "    <ImageView\n" +
                        "        android:layout_width=\"match_parent\"\n" +
                        "        android:layout_height=\"match_parent\"\n" +
                        "        android:src=\"@drawable/background\"/>\n" +
                        "\n" +
                        "    <TextView\n" +
                        "        android:layout_gravity=\"center\"\n" +
                        "        android:text=\"স্বাগতম\"\n" +
                        "        android:textColor=\"#FFFFFF\"\n" +
                        "        android:textSize=\"24sp\"\n" +
                        "        android:layout_width=\"wrap_content\"\n" +
                        "        android:layout_height=\"wrap_content\"/>\n" +
                        "</FrameLayout>\n" +
                        "\\`\\`\\`\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "### 5\uFE0F⃣ **TableLayout (টেবিল লেআউট)**\n" +
                        "\n" +
                        "* UI উপাদানগুলোকে টেবিলের মতো সারি ও কলামে সাজায়।\n" +
                        "* একাধিক \\`TableRow\\` ব্যবহার করে তৈরি হয়।\n" +
                        "\n" +
                        "\uD83D\uDCDD উদাহরণ:\n" +
                        "\n" +
                        "\\`\\`\\`xml\n" +
                        "<TableLayout\n" +
                        "    android:layout_width=\"match_parent\"\n" +
                        "    android:layout_height=\"wrap_content\">\n" +
                        "\n" +
                        "    <TableRow>\n" +
                        "        <TextView android:text=\"নাম\"/>\n" +
                        "        <EditText android:hint=\"আপনার নাম লিখুন\"/>\n" +
                        "    </TableRow>\n" +
                        "\n" +
                        "    <TableRow>\n" +
                        "        <TextView android:text=\"ইমেইল\"/>\n" +
                        "        <EditText android:hint=\"ইমেইল দিন\"/>\n" +
                        "    </TableRow>\n" +
                        "\n" +
                        "</TableLayout>\n" +
                        "\\`\\`\\`\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "### 6\uFE0F⃣ **GridLayout (গ্রিড লেআউট)**\n" +
                        "\n" +
                        "* এটি গ্রিড আকারে Layout তৈরি করে (সারি ও কলামে)।\n" +
                        "* অনেকটা TableLayout এর মতো, তবে আরও নিয়ন্ত্রণযোগ্য।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ⚙\uFE0F গুরুত্বপূর্ণ Layout Attributes (গুণাবলী)\n" +
                        "\n" +
                        "| অ্যাট্রিবিউট     | কাজ                                   |\n" +
                        "|-----------------|-------------------------------------|\n" +
                        "| \\`layout_width\\`   | ভিউ এর প্রস্থ                         |\n" +
                        "| \\`layout_height\\`  | ভিউ এর উচ্চতা                        |\n" +
                        "| \\`match_parent\\`   | প্যারেন্ট ভিউ এর পুরো সাইজ নেয়       |\n" +
                        "| \\`wrap_content\\`   | কনটেন্ট অনুযায়ী সাইজ নেয়            |\n" +
                        "| \\`orientation\\`    | ভিউ গুলোর দিক নির্ধারণ (LinearLayout) |\n" +
                        "| \\`gravity\\`        | ভিউ এর মধ্যে কনটেন্ট কোথায় থাকবে     |\n" +
                        "| \\`layout_gravity\\` | ভিউটি Layout এর মধ্যে কোথায় থাকবে    |\n" +
                        "| \\`padding\\`        | ভিউ এর ভিতরের ফাঁকা জায়গা            |\n" +
                        "| \\`margin\\`         | ভিউ এর বাইরের ফাঁকা জায়গা            |\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## \uD83D\uDDBC\uFE0F Layout Design করার উপায়\n" +
                        "\n" +
                        "### \uD83D\uDD39 Design View:\n" +
                        "\n" +
                        "* Android Studio তে Design ট্যাবে ক্লিক করে Drag & Drop করে UI তৈরি করতে পারেন।\n" +
                        "\n" +
                        "### \uD83D\uDD39 Code View:\n" +
                        "\n" +
                        "* XML কোড লিখে Layout তৈরি করা যায়।\n" +
                        "\n" +
                        "✅ ভালো ফলাফলের জন্য Design View ও Code View দুইটি একসাথে ব্যবহার করা ভালো।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ✅ Layout ব্যবহারে কিছু টিপস\n" +
                        "\n" +
                        "1. Nested Layout (একটির ভিতরে আরেকটি) বেশি ব্যবহার করবেন না — পারফরম্যান্স কমে যায়।\n" +
                        "2. Simple Layout এর জন্য \\`LinearLayout\\`\n" +
                        "3. Complex Layout এর জন্য \\`ConstraintLayout\\`\n" +
                        "4. রেসপনসিভ UI ডিজাইনের জন্য \\`dp\\`, \\`sp\\`, \\`wrap_content\\`, \\`match_parent\\` ব্যবহার করুন।\n" +
                        "5. UI Preview সবসময় Check করে নিন Design View তে।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## \uD83E\uDD20 Extra: LayoutInflater\n" +
                        "\n" +
                        "Java/Kotlin কোড থেকে Layout লোড করতে হলে \\`LayoutInflater\\` ব্যবহার করতে হয়।\n" +
                        "\n" +
                        "### উদাহরণ (Kotlin):\n" +
                        "\n" +
                        "\\`\\`\\`kotlin\n" +
                        "val view = LayoutInflater.from(context).inflate(R.layout.custom_layout, parent, false)\n" +
                        "\\`\\`\\`\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## \uD83D\uDCDD উপসংহার\n" +
                        "\n" +
                        "| Layout           | ব্যবহার                          |\n" +
                        "|------------------|---------------------------------|\n" +
                        "| LinearLayout     | সোজা UI এর জন্য                  |\n" +
                        "| RelativeLayout   | আপেক্ষিক অবস্থান নির্ধারণের জন্য |\n" +
                        "| ConstraintLayout | আধুনিক ও জটিল UI এর জন্য         |\n" +
                        "| FrameLayout      | Overlay বা Simple Layout এর জন্য |\n" +
                        "| TableLayout      | ফর্ম টাইপ ডিজাইনের জন্য          |\n" +
                        "| GridLayout       | গ্রিড ভিত্তিক ডিজাইন             |\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## \uD83D\uDCDA শেখার পরবর্তী ধাপ:\n" +
                        "\n" +
                        "* ViewGroup এবং View এর মধ্যে পার্থক্য বোঝা\n" +
                        "* RecyclerView ও Adapter নিয়ে কাজ শেখা\n" +
                        "* Material Design Components ব্যবহার শেখা (CardView, AppBarLayout, BottomNavigationView)\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "তুমি চাইলে আমি প্রতিটা Layout এর জন্য আলাদা উদাহরণসহ প্র্যাকটিস প্রজেক্ট ফাইল তৈরি করে দিতে পারি। তুমি কীভাবে শিখতে ভালোবাসো—কোড লিখে, না ভিডিও দেখে?\n" +
                        "\n" +
                        "✍\uFE0F বলো, আমি তোমাকে পরবর্তী ধাপ দেখিয়ে দিই।\n" +
                        "`;\n" +
                        "\n";

            case "Chapter 4: Activities and Intents":
                return "অবশ্যই! নিচে বাংলায় **Android App Development** এর দুই গুরুত্বপূর্ণ বিষয় — **Activities** এবং **Intents** সম্পর্কে বিস্তারিত ধারণা দেওয়া হলো।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "# \uD83D\uDD25 Android Activities এবং Intents - সম্পূর্ণ গাইড (বাংলায়)\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ১. Activity কী? (What is an Activity?)\n" +
                        "\n" +
                        "**Activity** হলো Android অ্যাপ্লিকেশনের একটি স্ক্রিন বা UI যা ব্যবহারকারীর সাথে ইন্টারঅ্যাকশন করে। সহজ কথায়, অ্যাপের প্রতিটা ভিজিবল স্ক্রিনকে Activity বলা হয়।\n" +
                        "\n" +
                        "> **উদাহরণ:**\n" +
                        "> একটি মেসেজিং অ্যাপে Inbox দেখানো স্ক্রিন একটা Activity, আর মেসেজ লেখার স্ক্রিন আরেকটা Activity।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "### Activity এর বৈশিষ্ট্য:\n" +
                        "\n" +
                        "* প্রতিটি Activity একটি UI উপস্থাপন করে।\n" +
                        "* AndroidManifest.xml ফাইলে প্রতিটি Activity ডিক্লেয়ার করতে হয়।\n" +
                        "* Activity lifecycle (জীবনচক্র) থাকে, অর্থাৎ শুরু থেকে শেষ পর্যন্ত নানা স্টেট (স্টার্ট, পজ, স্টপ ইত্যাদি) অতিক্রম করে।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ২. Activity Lifecycle (জীবনচক্র)\n" +
                        "\n" +
                        "Activity এর বিভিন্ন স্টেজ বা অবস্থা বোঝা খুবই গুরুত্বপূর্ণ। কারণ এর উপরই নির্ভর করে অ্যাপ কীভাবে কাজ করবে।\n" +
                        "\n" +
                        "### প্রধান Lifecycle Methods:\n" +
                        "\n" +
                        "| মেথড          | কাজ                                                          |\n" +
                        "| ------------- | ------------------------------------------------------------ |\n" +
                        "| `onCreate()`  | Activity তৈরি ও শুরু করার সময় কল হয়। UI সেটআপ হয়।            |\n" +
                        "| `onStart()`   | Activity ব্যবহারকারীর জন্য দৃশ্যমান হয়।                      |\n" +
                        "| `onResume()`  | Activity ইউজারের সাথে ইন্টারঅ্যাক্ট করতে প্রস্তুত।           |\n" +
                        "| `onPause()`   | Activity আংশিকভাবে দৃশ্যমান কিন্তু অন্য Activity সামনে আসছে। |\n" +
                        "| `onStop()`    | Activity সম্পূর্ণ অদৃশ্য হয়ে যায়।                            |\n" +
                        "| `onDestroy()` | Activity ধ্বংস হচ্ছে, মেমোরি মুক্ত হচ্ছে।                    |\n" +
                        "| `onRestart()` | Activity আবার শুরু হচ্ছে (Stop থেকে Start এ)                 |\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৩. Activity এর একটি সাধারণ উদাহরণ (Java):\n" +
                        "\n" +
                        "```java\n" +
                        "public class MainActivity extends AppCompatActivity {\n" +
                        "    @Override\n" +
                        "    protected void onCreate(Bundle savedInstanceState) {\n" +
                        "        super.onCreate(savedInstanceState);\n" +
                        "        setContentView(R.layout.activity_main);  // UI লেআউট লোড করা\n" +
                        "    }\n" +
                        "}\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৪. Intent কী? (What is an Intent?)\n" +
                        "\n" +
                        "**Intent** হলো Android এর একটি Messaging Object যা Activities, Services, Broadcast Receiver ইত্যাদির মধ্যে যোগাযোগের মাধ্যম হিসেবে কাজ করে।\n" +
                        "\n" +
                        "* এক ধরনের “ইচ্ছাপত্র” যা বলে তুমি কী করতে চাও।\n" +
                        "* অন্য Activity চালু করা, কোন সার্ভিস শুরু করা, বা কোন ডেটা শেয়ার করার জন্য ব্যবহৃত হয়।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৫. Intent এর দুই ধরনের ব্যবহার:\n" +
                        "\n" +
                        "### ১) Explicit Intent (স্পষ্ট উদ্দেশ্য)\n" +
                        "\n" +
                        "* সরাসরি নির্দিষ্ট Activity বা Component কে টার্গেট করে।\n" +
                        "* সাধারণত Activity থেকে আরেকটি Activity চালু করার জন্য ব্যবহৃত হয়।\n" +
                        "\n" +
                        "### উদাহরণ:\n" +
                        "\n" +
                        "```java\n" +
                        "Intent intent = new Intent(MainActivity.this, SecondActivity.class);\n" +
                        "startActivity(intent);\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "### ২) Implicit Intent (অস্পষ্ট উদ্দেশ্য)\n" +
                        "\n" +
                        "* নির্দিষ্ট Activity উল্লেখ করে না, বরং কাজের ধরন (action) উল্লেখ করে।\n" +
                        "* সিস্টেম সেই কাজ করতে পারা যেকোন Activity চালু করতে পারে।\n" +
                        "\n" +
                        "### উদাহরণ:\n" +
                        "\n" +
                        "```java\n" +
                        "Intent intent = new Intent(Intent.ACTION_VIEW);\n" +
                        "intent.setData(Uri.parse(\"https://www.google.com\"));\n" +
                        "startActivity(intent);\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৬. Intent এর অন্যান্য গুরুত্বপূর্ণ অংশ\n" +
                        "\n" +
                        "| অংশ      | কাজ                                                                           |\n" +
                        "| -------- | ----------------------------------------------------------------------------- |\n" +
                        "| Action   | Intent এর প্রধান কাজ নির্ধারণ করে। যেমন `ACTION_VIEW`, `ACTION_SEND` ইত্যাদি। |\n" +
                        "| Data     | Intent এর সাথে ডেটা যুক্ত করা হয় (যেমন URL, ফোন নম্বর)।                       |\n" +
                        "| Extras   | অতিরিক্ত তথ্য (key-value pair) যোগ করা হয়।                                    |\n" +
                        "| Category | Intent এর ক্যাটাগরি নির্ধারণ করে (অতিরিক্ত ফিল্টার)।                          |\n" +
                        "| Flags    | Activity চালানোর নির্দিষ্ট নিয়ম দেয় (যেমন নতুন টাস্কে খোলা)।                  |\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৭. Activity থেকে অন্য Activity তে ডেটা পাঠানো\n" +
                        "\n" +
                        "```java\n" +
                        "Intent intent = new Intent(MainActivity.this, SecondActivity.class);\n" +
                        "intent.putExtra(\"username\", \"Rafiq\");\n" +
                        "startActivity(intent);\n" +
                        "```\n" +
                        "\n" +
                        "**SecondActivity তে ডেটা গ্রহণ:**\n" +
                        "\n" +
                        "```java\n" +
                        "String username = getIntent().getStringExtra(\"username\");\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৮. Activity থেকে ফলাফল নিয়ে আসা (StartActivityForResult)\n" +
                        "\n" +
                        "কখনো কখনো তুমি চাইবে অন্য Activity থেকে কিছু ফলাফল পেতে।\n" +
                        "\n" +
                        "```java\n" +
                        "// MainActivity থেকে SecondActivity চালানো\n" +
                        "Intent intent = new Intent(MainActivity.this, SecondActivity.class);\n" +
                        "startActivityForResult(intent, 1);\n" +
                        "```\n" +
                        "\n" +
                        "**SecondActivity তে ফলাফল সেট করা:**\n" +
                        "\n" +
                        "```java\n" +
                        "Intent returnIntent = new Intent();\n" +
                        "returnIntent.putExtra(\"result\", \"Some data\");\n" +
                        "setResult(Activity.RESULT_OK, returnIntent);\n" +
                        "finish();\n" +
                        "```\n" +
                        "\n" +
                        "**MainActivity তে ফলাফল নেওয়া:**\n" +
                        "\n" +
                        "```java\n" +
                        "@Override\n" +
                        "protected void onActivityResult(int requestCode, int resultCode, Intent data) {\n" +
                        "    super.onActivityResult(requestCode, resultCode, data);\n" +
                        "    if (requestCode == 1 && resultCode == RESULT_OK) {\n" +
                        "        String result = data.getStringExtra(\"result\");\n" +
                        "        // ফলাফল ব্যবহার করুন\n" +
                        "    }\n" +
                        "}\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৯. Activity ও Intent সম্পর্কে গুরুত্বপূর্ণ টিপস\n" +
                        "\n" +
                        "* প্রতিটি Activity অবশ্যই AndroidManifest.xml এ ডিক্লেয়ার করতে হবে।\n" +
                        "* Intent ব্যবহার করে Activity চালানোর সময় context খুব গুরুত্বপূর্ণ (সাধারণত `this` বা `ActivityName.this`)।\n" +
                        "* Activity lifecycle এর প্রতিটি মেথডে প্রয়োজন অনুযায়ী কাজ করতে হয় যেন ভালো ইউজার এক্সপেরিয়েন্স পাওয়া যায়।\n" +
                        "* Implicit Intent ব্যবহারে সবসময় নিশ্চিত হতে হবে যে কাজটি করতে পারার মতো Activity ডিভাইসে আছে কিনা।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ১০. উপসংহার\n" +
                        "\n" +
                        "| বিষয়            | সংক্ষিপ্ত বর্ণনা                                      |\n" +
                        "| --------------- | ----------------------------------------------------- |\n" +
                        "| Activity        | UI এর একটি স্ক্রিন যা ইউজারের সাথে ইন্টারঅ্যাক্ট করে। |\n" +
                        "| Intent          | কম্পোনেন্টের মধ্যে বার্তা পাঠানোর মাধ্যম।             |\n" +
                        "| Explicit Intent | নির্দিষ্ট Activity কে টার্গেট করে।                    |\n" +
                        "| Implicit Intent | কাজের ধরন অনুযায়ী Activity নির্বাচন করে।              |\n" +
                        "| Lifecycle       | Activity এর স্টেট পরিবর্তন বুঝতে সাহায্য করে।         |\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "### তোমার জন্য প্র্যাকটিস আইডিয়া:\n" +
                        "\n" +
                        "* একটি অ্যাপ বানাও যেখানে দুইটি Activity থাকবে এবং প্রথম Activity থেকে দ্বিতীয় Activity তে নাম পাঠানো হবে।\n" +
                        "* দ্বিতীয় Activity থেকে ফিরে আসার সময় একটি মেসেজ রিটার্ন করাও।\n" +
                        "* Implicit Intent দিয়ে ব্রাউজার, কল বা ম্যাপ চালানোর চেষ্টা করো।\n" +
                        "\n" +
                        "---\n" +
                        "\n";
            case "Chapter 5: Views and Widgets":
                return "# \uD83D\uDCF1 Android Views এবং Widgets n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ১. View কী? (What is a View?)\n" +
                        "\n" +
                        "**View** হলো Android এর UI (User Interface) এর সবচেয়ে ছোট ইউনিট। এটি যেকোনো UI উপাদান যা স্ক্রিনে দেখা যায় এবং ইউজারের সাথে ইন্টারঅ্যাক্ট করে।\n" +
                        "\n" +
                        "> **উদাহরণ:**\n" +
                        "> Button, TextView, ImageView, EditText এগুলো সবই View।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ২. Widget কী? (What is a Widget?)\n" +
                        "\n" +
                        "**Widget** আসলে View এর বিশেষ ধরনের সাবক্লাস, যা সাধারণত ইউজারের সাথে ইন্টারঅ্যাক্ট করার জন্য ব্যবহৃত হয়। অনেক সময় Widget শব্দটি View এর সমার্থক হিসেবে ব্যবহৃত হয়।\n" +
                        "\n" +
                        "> সহজ ভাষায়:\n" +
                        "> **Widget = View + ইন্টারঅ্যাকশন**\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৩. View এর ধরন\n" +
                        "\n" +
                        "### ১) Basic Views\n" +
                        "\n" +
                        "* **TextView:** টেক্সট দেখানোর জন্য।\n" +
                        "* **ImageView:** ছবি দেখানোর জন্য।\n" +
                        "* **Button:** ক্লিক করার জন্য বোতাম।\n" +
                        "* **EditText:** ইউজার ইনপুট নেয়ার জন্য।\n" +
                        "\n" +
                        "### ২) ViewGroup (Container Views)\n" +
                        "\n" +
                        "* ViewGroup হলো এমন View যা অন্যান্য View কে ধারণ করে।\n" +
                        "* যেমন: LinearLayout, RelativeLayout, ConstraintLayout ইত্যাদি।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৪. Android এর কিছু সাধারণ Widgets এর উদাহরণ\n" +
                        "\n" +
                        "| Widget Name | কাজ                                     | XML উদাহরণ                                    |\n" +
                        "| ----------- | --------------------------------------- | --------------------------------------------- |\n" +
                        "| TextView    | টেক্সট দেখানোর জন্য                     | `<TextView android:text=\"স্বাগতম\"/>`          |\n" +
                        "| Button      | ক্লিক করার জন্য বোতাম                   | `<Button android:text=\"চাপ দিন\"/>`            |\n" +
                        "| EditText    | টেক্সট ইনপুট নেওয়ার জন্য                | `<EditText android:hint=\"লিখুন\"/>`            |\n" +
                        "| ImageView   | ছবি দেখানোর জন্য                        | `<ImageView android:src=\"@drawable/img\"/>`    |\n" +
                        "| CheckBox    | চেকবক্স (হ্যাঁ/না)                      | `<CheckBox android:text=\"সেট করুন\"/>`         |\n" +
                        "| RadioButton | রেডিও বাটন (মাল্টিপল অপশন থেকে সিলেক্ট) | `<RadioButton android:text=\"পছন্দ করুন\"/>`    |\n" +
                        "| Switch      | অন/অফ টগল করার জন্য                     | `<Switch android:text=\"সেটিংস\"/>`             |\n" +
                        "| ProgressBar | লোডিং ইন্ডিকেটর                         | `<ProgressBar android:indeterminate=\"true\"/>` |\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৫. View এর গুরুত্বপূর্ণ Attributes (গুণাবলী)\n" +
                        "\n" +
                        "| Attribute               | কাজ                                    |\n" +
                        "| ----------------------- | -------------------------------------- |\n" +
                        "| `android:id`            | ভিউ এর আইডি নির্ধারণ করে।              |\n" +
                        "| `android:layout_width`  | ভিউ এর প্রস্থ নির্ধারণ করে।            |\n" +
                        "| `android:layout_height` | ভিউ এর উচ্চতা নির্ধারণ করে।            |\n" +
                        "| `android:text`          | টেক্সট সেট করে (যদি ভিউ টেক্সট দেখায়)। |\n" +
                        "| `android:src`           | ছবি সেট করে (ImageView এর জন্য)।       |\n" +
                        "| `android:hint`          | ইনপুট ফিল্ডে হিন্ট দেখায়।              |\n" +
                        "| `android:visibility`    | ভিউ দেখানো বা লুকানোর জন্য।            |\n" +
                        "| `android:background`    | ব্যাকগ্রাউন্ড কালার বা ছবি নির্ধারণ।   |\n" +
                        "| `android:padding`       | ভিউ এর ভিতরের ফাঁকা জায়গা।             |\n" +
                        "| `android:margin`        | ভিউ এর বাইরের ফাঁকা জায়গা।             |\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৬. Views কে Java/Kotlin কোড থেকে নিয়ন্ত্রণ করা\n" +
                        "\n" +
                        "### উদাহরণ (Java):\n" +
                        "\n" +
                        "```java\n" +
                        "TextView textView = findViewById(R.id.myTextView);\n" +
                        "textView.setText(\"হ্যালো, অ্যান্ড্রয়েড!\");\n" +
                        "```\n" +
                        "\n" +
                        "### উদাহরণ (Kotlin):\n" +
                        "\n" +
                        "```kotlin\n" +
                        "val textView: TextView = findViewById(R.id.myTextView)\n" +
                        "textView.text = \"হ্যালো, অ্যান্ড্রয়েড!\"\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৭. Custom View তৈরি করা\n" +


                        "---\n" +
                        "\n" +
                        "## ৮. View এর সাথে ইন্টারঅ্যাকশন\n" +
                        "\n" +
                        "* **Click Listener:** ইউজার যখন কোন View এ ক্লিক করে তখন এর জন্য লিসেনার যোগ করতে হয়।\n" +
                        "\n" +
                        "```java\n" +
                        "button.setOnClickListener(new View.OnClickListener() {\n" +
                        "    @Override\n" +
                        "    public void onClick(View v) {\n" +
                        "        // ক্লিক হ্যান্ডল করা হচ্ছে\n" +
                        "    }\n" +
                        "});\n" +
                        "```\n" +
                        "\n" +
                        "কিন্তু Kotlin এ এটা আরো সংক্ষিপ্ত:\n" +
                        "\n" +
                        "```kotlin\n" +
                        "button.setOnClickListener {\n" +
                        "    // ক্লিক হ্যান্ডল করা হচ্ছে\n" +
                        "}\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৯. View Group ও Layouts\n" +
                        "\n" +
                        "* **ViewGroup** হলো Container View, যা অন্য View বা ViewGroup ধারণ করে।\n" +
                        "* Layouts যেমন LinearLayout, RelativeLayout, ConstraintLayout হলো ViewGroup এর উদাহরণ।\n" +
                        "* Layout এর সাহায্যে Views গুলো স্ক্রিনে সুন্দরভাবে সাজানো হয়।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ১০. উপসংহার\n" +
                        "\n" +
                        "| বিষয়       | সংক্ষিপ্ত বর্ণনা                                      |\n" +
                        "| ---------- | ----------------------------------------------------- |\n" +
                        "| View       | Android UI এর ছোট একক, যেমন TextView, Button ইত্যাদি। |\n" +
                        "| Widget     | ইন্টারঅ্যাক্টিভ View, ইউজারের সাথে যোগাযোগ করে।       |\n" +
                        "| ViewGroup  | অন্য View ধারণ করার জন্য Container।                   |\n" +
                        "| Attributes | View এর বৈশিষ্ট্য নির্ধারণ করে।                       |\n" +
                        "| Listeners  | ইউজারের ইনপুট বা ইন্টারঅ্যাকশন হ্যান্ডল করে।          |\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## তোমার জন্য চ্যালেঞ্জ:\n" +
                        "\n" +
                        "* একটি লেআউট তৈরি করো যেখানে TextView, EditText, Button থাকবে।\n" +
                        "* Button ক্লিক করলে EditText এর লেখা TextView তে দেখাবে।\n" +
                        "* নিজে থেকে নতুন কোন Widget যোগ করার চেষ্টা করো এবং তার বৈশিষ্ট্য কাস্টমাইজ করো।\n"


                        ;
            case "Chapter 6: RecyclerView":
                return
                        "# \uD83D\uDCCB Android RecyclerView \n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ১. RecyclerView কী? (What is RecyclerView?)\n" +
                        "\n" +
                        "**RecyclerView** হলো একটি ভিউ যা অনেক সংখ্যক আইটেম বা ডেটা স্ক্রিনে দেখানোর জন্য ব্যবহৃত হয়। এটি Efficient এবং Flexible কারণ এটি স্ক্রলিং এর সময় শুধুমাত্র দৃশ্যমান আইটেমগুলোই তৈরি করে, বাকি আইটেমগুলোকে রিসাইকেল করে ব্যবহার করে — ফলে পারফরম্যান্স অনেক ভালো হয়।\n" +
                        "\n" +
                        "> আগে আমরা ListView ব্যবহার করতাম, কিন্তু RecyclerView অনেক বেশি উন্নত এবং কাস্টমাইজযোগ্য।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ২. RecyclerView এর প্রয়োজন কেন?\n" +
                        "\n" +
                        "* অনেক বড় ডেটা লিস্ট দেখাতে হলে সব আইটেম একসাথে লোড করলে মেমোরি ও পারফরম্যান্স সমস্যা হয়।\n" +
                        "* RecyclerView এর মাধ্যমে শুধু যে আইটেমগুলো স্ক্রিনে দেখা যাবে সেগুলোই তৈরি হয়।\n" +
                        "* View গুলো পুনরায় ব্যবহার (recycle) করা হয়, ফলে দ্রুত এবং স্মার্ট কাজ হয়।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৩. RecyclerView এর প্রধান কম্পোনেন্টসমূহ\n" +
                        "\n" +
                        "| কম্পোনেন্ট        | কাজ                                                                                    |\n" +
                        "| ----------------- | -------------------------------------------------------------------------------------- |\n" +
                        "| **RecyclerView**  | মূল ভিউ যা লিস্ট বা গ্রিড হিসেবে ডেটা দেখায়।                                           |\n" +
                        "| **Adapter**       | ডেটা এবং ভিউ এর মধ্যে ব্রিজ, প্রতিটি আইটেম কিভাবে দেখাবে তা নির্ধারণ করে।              |\n" +
                        "| **ViewHolder**    | প্রতিটি আইটেমের ভিউকে ক্যাশ করে রাখে, ফলে দ্রুত স্ক্রোলিং হয়।                          |\n" +
                        "| **LayoutManager** | RecyclerView এর আইটেমগুলো কীভাবে সাজানো হবে (লিনিয়ার, গ্রিড ইত্যাদি) তা নিয়ন্ত্রণ করে। |\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৪. RecyclerView সেটআপের ধাপ\n" +
                        "\n" +
                        "### ধাপ ১: ডিপেন্ডেন্সি যোগ করা (build.gradle)\n" +
                        "\n" +
                        "```gradle\n" +
                        "dependencies {\n" +
                        "    implementation \"androidx.recyclerview:recyclerview:1.2.1\"\n" +
                        "}\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "### ধাপ ২: XML লেআউটে RecyclerView যোগ করা\n" +
                        "\n" +
                        "```xml\n" +
                        "<androidx.recyclerview.widget.RecyclerView\n" +
                        "    android:id=\"@+id/recyclerView\"\n" +
                        "    android:layout_width=\"match_parent\"\n" +
                        "    android:layout_height=\"match_parent\"/>\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "### ধাপ ৩: আইটেম লেআউট তৈরি করা (item_layout.xml)\n" +
                        "\n" +
                        "```xml\n" +
                        "<TextView\n" +
                        "    android:id=\"@+id/itemText\"\n" +
                        "    android:layout_width=\"match_parent\"\n" +
                        "    android:layout_height=\"wrap_content\"\n" +
                        "    android:padding=\"16dp\"\n" +
                        "    android:textSize=\"18sp\"/>\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "### ধাপ ৪: Adapter ও ViewHolder তৈরি করা\n" +
                        "\n" +
                        "```java\n" +
                        "public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {\n" +
                        "\n" +
                        "    private List<String> dataList;\n" +
                        "\n" +
                        "    public MyAdapter(List<String> dataList) {\n" +
                        "        this.dataList = dataList;\n" +
                        "    }\n" +
                        "\n" +
                        "    public static class MyViewHolder extends RecyclerView.ViewHolder {\n" +
                        "        TextView itemText;\n" +
                        "\n" +
                        "        public MyViewHolder(View itemView) {\n" +
                        "            super(itemView);\n" +
                        "            itemText = itemView.findViewById(R.id.itemText);\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {\n" +
                        "        View v = LayoutInflater.from(parent.getContext())\n" +
                        "                .inflate(R.layout.item_layout, parent, false);\n" +
                        "        return new MyViewHolder(v);\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public void onBindViewHolder(MyViewHolder holder, int position) {\n" +
                        "        holder.itemText.setText(dataList.get(position));\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public int getItemCount() {\n" +
                        "        return dataList.size();\n" +
                        "    }\n" +
                        "}\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "### ধাপ ৫: Activity বা Fragment এ RecyclerView সেট করা\n" +
                        "\n" +
                        "```java\n" +
                        "RecyclerView recyclerView = findViewById(R.id.recyclerView);\n" +
                        "recyclerView.setLayoutManager(new LinearLayoutManager(this));\n" +
                        "\n" +
                        "List<String> items = Arrays.asList(\"আইটেম ১\", \"আইটেম ২\", \"আইটেম ৩\");\n" +
                        "MyAdapter adapter = new MyAdapter(items);\n" +
                        "recyclerView.setAdapter(adapter);\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৫. LayoutManager এর ধরন\n" +
                        "\n" +
                        "| LayoutManager              | কাজ                                                     |\n" +
                        "| -------------------------- | ------------------------------------------------------- |\n" +
                        "| LinearLayoutManager        | ListView মত লাইন ধরে সাজায় (Vertical বা Horizontal)     |\n" +
                        "| GridLayoutManager          | Grid আকারে সাজায় (সারি ও কলামে)                         |\n" +
                        "| StaggeredGridLayoutManager | বিভিন্ন সাইজের আইটেম নিয়ে গ্রিড বানায় (Pinterest style) |\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৬. Item Click Listener যোগ করা\n" +
                        "\n" +
                        "```java\n" +
                        "public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {\n" +
                        "\n" +
                        "    // ... আগের কোড ...\n" +
                        "\n" +
                        "    private OnItemClickListener listener;\n" +
                        "\n" +
                        "    public interface OnItemClickListener {\n" +
                        "        void onItemClick(int position);\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setOnItemClickListener(OnItemClickListener listener) {\n" +
                        "        this.listener = listener;\n" +
                        "    }\n" +
                        "\n" +
                        "    public class MyViewHolder extends RecyclerView.ViewHolder {\n" +
                        "        TextView itemText;\n" +
                        "\n" +
                        "        public MyViewHolder(View itemView) {\n" +
                        "            super(itemView);\n" +
                        "            itemText = itemView.findViewById(R.id.itemText);\n" +
                        "\n" +
                        "            itemView.setOnClickListener(new View.OnClickListener() {\n" +
                        "                @Override\n" +
                        "                public void onClick(View v) {\n" +
                        "                    if (listener != null) {\n" +
                        "                        int position = getAdapterPosition();\n" +
                        "                        if (position != RecyclerView.NO_POSITION) {\n" +
                        "                            listener.onItemClick(position);\n" +
                        "                        }\n" +
                        "                    }\n" +
                        "                }\n" +
                        "            });\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    // ... বাকী কোড ...\n" +
                        "}\n" +
                        "```\n" +
                        "\n" +
                        "**Activity তে:**\n" +
                        "\n" +
                        "```java\n" +
                        "adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {\n" +
                        "    @Override\n" +
                        "    public void onItemClick(int position) {\n" +
                        "        Toast.makeText(MainActivity.this, \"Clicked: \" + position, Toast.LENGTH_SHORT).show();\n" +
                        "    }\n" +
                        "});\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৭. উপসংহার\n" +
                        "\n" +
                        "| বিষয়           | সংক্ষিপ্ত বর্ণনা                         |\n" +
                        "| -------------- | ---------------------------------------- |\n" +
                        "| RecyclerView   | Efficient List/Grid UI উপাদান            |\n" +
                        "| Adapter        | ডেটা ও ভিউ এর মধ্যস্থতাকারী              |\n" +
                        "| ViewHolder     | আইটেমের ভিউ ক্যাশ করে পারফরম্যান্স বাড়ায় |\n" +
                        "| LayoutManager  | আইটেমের লেআউট কন্ট্রোল করে               |\n" +
                        "| Click Listener | আইটেম ক্লিক হ্যান্ডলিং                   |\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## তোমার জন্য চ্যালেঞ্জ:\n" +
                        "\n" +
                        "* নিজের একটি List তৈরি করো যেটাতে তোমার পছন্দের বই বা সিনেমার নাম থাকবে।\n" +
                        "* আইটেমে ক্লিক করলে Toast দেখাও।\n" +
                        "* GridLayoutManager দিয়ে গ্রিড আকারে দেখাও।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "যদি চাও, আমি তোমার জন্য RecyclerView নিয়ে একটি সম্পূর্ণ প্রজেক্ট ফাইল তৈরি করে দিতে পারি বা কোড ডেমো দিতে পারি। কীভাবে শিখতে ভালোবাসো — কোড লিখে, না ভিডিও দেখে? বলো! \uD83D\uDE0A\n";
            case "Chapter 7: Data Storage":
                return
                        "# \uD83D\uDCBE Android Data Storage\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ১. Data Storage কী?\n" +
                        "\n" +
                        "Android অ্যাপে ইউজারের ডেটা সংরক্ষণ করা হয় যাতে পরে সেই ডেটা পুনরায় ব্যবহার করা যায়। ডেটা স্টোরেজ বলতে আমরা বুঝি, কোন ধরনের ডেটা কোথায় এবং কিভাবে সেভ করা হয়।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ২. Android এ ডেটা স্টোরেজের প্রধান ধরনসমূহ\n" +
                        "\n" +
                        "| স্টোরেজ টাইপ          | ব্যবহার                                                  | ডেটার ধরন                   |\n" +
                        "| --------------------- | -------------------------------------------------------- | --------------------------- |\n" +
                        "| **SharedPreferences** | ছোট ও সিম্পল ডেটা যেমন সেটিংস, ইউজার প্রেফারেন্স সংরক্ষণ | কী-ভ্যালু (Key-Value) পেয়ার |\n" +
                        "| **Internal Storage**  | প্রাইভেট ফাইল সেভ করার জন্য                              | ফাইল ফরম্যাট (Text, Binary) |\n" +
                        "| **External Storage**  | পাবলিক ফাইল যেমন ছবি, ভিডিও সেভ করার জন্য                | ফাইল (Media, Documents)     |\n" +
                        "| **SQLite Database**   | স্ট্রাকচার্ড ডেটা সংরক্ষণ ও অনুসন্ধানের জন্য             | টেবিল ভিত্তিক ডেটাবেস       |\n" +
                        "| **Room Database**     | SQLite এর উপরে আধুনিক অ্যাবস্ট্রাকশন লেয়ারের মতো         | ORM ভিত্তিক ডেটাবেস         |\n" +
                        "| **Content Provider**  | ডেটা শেয়ার করার জন্য অ্যাপ থেকে অন্য অ্যাপের সাথে        | বিভিন্ন ফরম্যাট             |\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৩. SharedPreferences (সহজ সেটিংস স্টোরেজ)\n" +
                        "\n" +
                        "* কী-ভ্যালু ফরম্যাটে ছোট ডেটা সেভ করার জন্য ব্যবহৃত।\n" +
                        "* যেমন ইউজার লগইন স্ট্যাটাস, থিম সিলেকশন ইত্যাদি।\n" +
                        "\n" +
                        "### ব্যবহার (Kotlin):\n" +
                        "\n" +
                        "```kotlin\n" +
                        "val sharedPref = getSharedPreferences(\"MyPref\", Context.MODE_PRIVATE)\n" +
                        "val editor = sharedPref.edit()\n" +
                        "editor.putString(\"username\", \"rahim\")\n" +
                        "editor.apply()\n" +
                        "```\n" +
                        "\n" +
                        "### ডেটা পড়া:\n" +
                        "\n" +
                        "```kotlin\n" +
                        "val username = sharedPref.getString(\"username\", \"ডিফল্ট নাম\")\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৪. Internal Storage (অ্যাপ স্পেসে ফাইল সেভ করা)\n" +
                        "\n" +
                        "* ইউজারের ডিভাইসে অ্যাপ এর প্রাইভেট স্পেসে ফাইল রাখা হয়।\n" +
                        "* অন্য অ্যাপ থেকে অ্যাক্সেস করা যায় না।\n" +
                        "\n" +
                        "### ফাইল সেভ করা:\n" +
                        "\n" +
                        "```kotlin\n" +
                        "val filename = \"myfile.txt\"\n" +
                        "val fileContents = \"Hello Android\"\n" +
                        "openFileOutput(filename, Context.MODE_PRIVATE).use {\n" +
                        "    it.write(fileContents.toByteArray())\n" +
                        "}\n" +
                        "```\n" +
                        "\n" +
                        "### ফাইল পড়া:\n" +
                        "\n" +
                        "```kotlin\n" +
                        "val fileInputStream = openFileInput(filename)\n" +
                        "val content = fileInputStream.bufferedReader().useLines { lines ->\n" +
                        "    lines.fold(\"\") { some, text -> some + text }\n" +
                        "}\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৫. External Storage (সাধারণ ফাইল সেভ করা)\n" +
                        "\n" +
                        "* ছবি, ভিডিও, ডকুমেন্ট ইত্যাদি ফাইল সেভ করার জন্য।\n" +
                        "* Android 10+ থেকে বেশি পারমিশন ও স্টোরেজ অ্যাক্সেস নিয়ন্ত্রণ রয়েছে।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৬. SQLite Database\n" +
                        "\n" +
                        "* স্ট্রাকচার্ড ডেটা সংরক্ষণের জন্য।\n" +
                        "* টেবিল, কলাম, রো-র মাধ্যমে ডেটা ম্যানেজ করে।\n" +
                        "\n" +
                        "### SQLiteHelper ক্লাস তৈরি করে ডাটাবেস ব্যবস্থাপনা করা হয়।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৭. Room Database (SQLite এর উপরে আধুনিক লেয়ার)\n" +
                        "\n" +
                        "* SQLite কে আরও সহজ ও টাইপ সেফ করে তোলে।\n" +
                        "* Entity, DAO (Data Access Object), Database ক্লাসের মাধ্যমে কাজ করে।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৮. Content Provider\n" +
                        "\n" +
                        "* অ্যাপ এর ডেটা অন্য অ্যাপ এর সাথে শেয়ার করার মাধ্যম।\n" +
                        "* যেমন Contact app এর ডেটা অন্য অ্যাপে শেয়ার করা।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৯. কোনটা কখন ব্যবহার করবেন?\n" +
                        "\n" +
                        "| ডেটার ধরন             | ব্যবহার করুন                 |\n" +
                        "| --------------------- | ---------------------------- |\n" +
                        "| ছোট ডেটা              | SharedPreferences            |\n" +
                        "| ফাইল (টেক্সট/বাইনারি) | Internal বা External Storage |\n" +
                        "| স্ট্রাকচার্ড ডেটা     | SQLite / Room Database       |\n" +
                        "| ডেটা শেয়ার            | Content Provider             |\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ১০. নিরাপত্তা বিষয়ক টিপস\n" +
                        "\n" +
                        "* Internal Storage ডেটা অন্য অ্যাপ থেকে প্রাইভেট থাকে।\n" +
                        "* External Storage এ ফাইল রাখা হলে পারমিশন দরকার।\n" +
                        "* সংবেদনশীল ডেটা এনক্রিপ্ট করা ভালো।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ১১. উপসংহার\n" +
                        "\n" +
                        "| স্টোরেজ টাইপ      | সুবিধা                             | সীমাবদ্ধতা                             |\n" +
                        "| ----------------- | ---------------------------------- | -------------------------------------- |\n" +
                        "| SharedPreferences | সহজ, দ্রুত, ছোট ডেটার জন্য উপযোগী  | বড় ডেটা রাখার উপযোগী নয়               |\n" +
                        "| Internal Storage  | প্রাইভেট ফাইল স্টোরেজ              | সীমিত স্পেস, ফাইল ম্যানেজমেন্ট প্রয়োজন |\n" +
                        "| External Storage  | মিডিয়া ও পাবলিক ফাইলের জন্য উপযোগী | পারমিশন ও নিরাপত্তা ঝুঁকি              |\n" +
                        "| SQLite / Room     | জটিল ও বড় ডেটার জন্য উপযোগী        | কোড বেশি, শিখতে সময় লাগে               |\n" +
                        "\n"


                     ;
            case "Chapter 8: Networking":
                return
                        "\n" +
                        "# \uD83D\uDCE1 Android Networking \n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ১. Android Networking কী?\n" +
                        "\n" +
                        "* Android Networking হলো তোমার অ্যাপের ইন্টারনেটের সাথে যোগাযোগ করার প্রক্রিয়া।\n" +
                        "* যেমন: ওয়েব সার্ভার থেকে ডেটা আনা (HTTP request), সার্ভারে ডেটা পাঠানো, ফাইল ডাউনলোড, ইত্যাদি।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ২. Networking এর জন্য কী কী দরকার?\n" +
                        "\n" +
                        "* **Internet Permission** তোমার অ্যাপের `AndroidManifest.xml` এ দিতে হবে।\n" +
                        "\n" +
                        "```xml\n" +
                        "<uses-permission android:name=\"android.permission.INTERNET\" />\n" +
                        "```\n" +
                        "\n" +
                        "* এরপর তুমি কোডের মাধ্যমে HTTP/HTTPS রিকোয়েস্ট পাঠাবে।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৩. Android-এ Networking করার পদ্ধতি\n" +
                        "\n" +
                        "### পদ্ধতি ১: HttpURLConnection (Java এর বিল্ট-ইন)\n" +
                        "\n" +
                        "* এটি Android এর স্ট্যান্ডার্ড HTTP ক্লায়েন্ট।\n" +
                        "* তবে এটা একটু জটিল এবং অনেক কোড লিখতে হয়।\n" +
                        "\n" +
                        "### পদ্ধতি ২: Third-party লাইব্রেরি ব্যবহার করা\n" +
                        "\n" +
                        "* সবচেয়ে জনপ্রিয়: **Retrofit**, **Volley**, **OkHttp** ইত্যাদি।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৪. HttpURLConnection দিয়ে সিম্পল GET Request\n" +
                        "\n" +
                        "```java\n" +
                        "new Thread(new Runnable() {\n" +
                        "    @Override\n" +
                        "    public void run() {\n" +
                        "        try {\n" +
                        "            URL url = new URL(\"https://jsonplaceholder.typicode.com/posts/1\");\n" +
                        "            HttpURLConnection connection = (HttpURLConnection) url.openConnection();\n" +
                        "            connection.setRequestMethod(\"GET\");\n" +
                        "\n" +
                        "            InputStream inputStream = connection.getInputStream();\n" +
                        "            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));\n" +
                        "\n" +
                        "            StringBuilder result = new StringBuilder();\n" +
                        "            String line;\n" +
                        "            while ((line = reader.readLine()) != null){\n" +
                        "                result.append(line);\n" +
                        "            }\n" +
                        "            reader.close();\n" +
                        "\n" +
                        "            // এখন তোমার JSON ডেটা result.toString() এ আছে\n" +
                        "            // UI আপডেট করতে runOnUiThread() ব্যবহার করতে হবে\n" +
                        "\n" +
                        "        } catch (Exception e) {\n" +
                        "            e.printStackTrace();\n" +
                        "        }\n" +
                        "    }\n" +
                        "}).start();\n" +
                        "```\n" +
                        "\n" +
                        "**মনে রাখবে:** নেটওয়ার্ক অপারেশনগুলো মেইন থ্রেডে (UI থ্রেড) করা যায় না, তাই আলাদা থ্রেড বা AsyncTask/Coroutines/Background Thread এ করতে হয়।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৫. Volley লাইব্রেরি ব্যবহার করে নেটওয়ার্কিং (সহজ ও দ্রুত)\n" +
                        "\n" +
                        "### Gradle এ যোগ করো:\n" +
                        "\n" +
                        "```gradle\n" +
                        "implementation 'com.android.volley:volley:1.2.1'\n" +
                        "```\n" +
                        "\n" +
                        "### GET Request উদাহরণ:\n" +
                        "\n" +
                        "```java\n" +
                        "RequestQueue queue = Volley.newRequestQueue(this);\n" +
                        "String url = \"https://jsonplaceholder.typicode.com/posts/1\";\n" +
                        "\n" +
                        "StringRequest stringRequest = new StringRequest(Request.Method.GET, url,\n" +
                        "    new Response.Listener<String>() {\n" +
                        "        @Override\n" +
                        "        public void onResponse(String response) {\n" +
                        "            // response হলো সার্ভার থেকে পাওয়া ডেটা\n" +
                        "            Log.d(\"Volley\", response);\n" +
                        "        }\n" +
                        "    }, new Response.ErrorListener() {\n" +
                        "        @Override\n" +
                        "        public void onErrorResponse(VolleyError error) {\n" +
                        "            Log.e(\"Volley\", \"Error: \" + error.getMessage());\n" +
                        "        }\n" +
                        "    });\n" +
                        "\n" +
                        "queue.add(stringRequest);\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৬. Retrofit লাইব্রেরি ব্যবহার (মডার্ন, শক্তিশালী)\n" +
                        "\n" +
                        "### Gradle এ যোগ করো:\n" +
                        "\n" +
                        "```gradle\n" +
                        "implementation 'com.squareup.retrofit2:retrofit:2.9.0'\n" +
                        "implementation 'com.squareup.retrofit2:converter-gson:2.9.0'\n" +
                        "```\n" +
                        "\n" +
                        "### ধাপে ধাপে:\n" +
                        "\n" +
                        "1. API Interface তৈরি করো:\n" +
                        "\n" +
                        "```java\n" +
                        "public interface ApiService {\n" +
                        "    @GET(\"posts/1\")\n" +
                        "    Call<Post> getPost();\n" +
                        "}\n" +
                        "```\n" +
                        "\n" +
                        "2. Retrofit Client তৈরি করো:\n" +
                        "\n" +
                        "```java\n" +
                        "Retrofit retrofit = new Retrofit.Builder()\n" +
                        "    .baseUrl(\"https://jsonplaceholder.typicode.com/\")\n" +
                        "    .addConverterFactory(GsonConverterFactory.create())\n" +
                        "    .build();\n" +
                        "\n" +
                        "ApiService apiService = retrofit.create(ApiService.class);\n" +
                        "```\n" +
                        "\n" +
                        "3. ডেটা রিকোয়েস্ট করো:\n" +
                        "\n" +
                        "```java\n" +
                        "Call<Post> call = apiService.getPost();\n" +
                        "call.enqueue(new Callback<Post>() {\n" +
                        "    @Override\n" +
                        "    public void onResponse(Call<Post> call, Response<Post> response) {\n" +
                        "        if(response.isSuccessful()){\n" +
                        "            Post post = response.body();\n" +
                        "            // ডেটা নিয়ে কাজ করো\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public void onFailure(Call<Post> call, Throwable t) {\n" +
                        "        // এরর হ্যান্ডেল করো\n" +
                        "    }\n" +
                        "});\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৭. JSON ডেটা পার্সিং (Parsing)\n" +
                        "\n" +
                        "* সার্ভার থেকে সাধারণত JSON ডেটা আসে।\n" +
                        "* Retrofit এর জন্য Gson ব্যবহার করা হয় যা অটোমেটিক ডেটাকে Java অবজেক্টে রূপান্তর করে।\n" +
                        "* Volley বা HttpURLConnection ব্যবহার করলে ম্যানুয়ালি `JSONObject` বা `JSONArray` দিয়ে পার্স করতে হবে।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৮. Network On Main Thread Exception কেন হয়?\n" +
                        "\n" +
                        "* Android এ মূল (UI) থ্রেডে নেটওয়ার্ক অপারেশন করা নিষিদ্ধ।\n" +
                        "* কারণ নেটওয়ার্ক ধীরগতির, এতে UI হ্যাং হতে পারে।\n" +
                        "* তাই সব নেটওয়ার্ক কল ব্যাকগ্রাউন্ড থ্রেডে করতে হবে।\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ৯. কিছু গুরুত্বপূর্ণ টিপস\n" +
                        "\n" +
                        "* **ইন্টারনেট পারমিশন দিবে অবশ্যই**\n" +
                        "* নেটওয়ার্ক অপারেশন ব্যাকগ্রাউন্ডে করো\n" +
                        "* ইউজারের কানেকশন স্ট্যাটাস চেক করো (online/offline)\n" +
                        "* পারফরম্যান্স ও ব্যাটারি সংরক্ষণ মাথায় রাখো\n" +
                        "* বড় ডেটা ডাউনলোড বা আপলোডের জন্য কাজের ফ্রেমওয়ার্ক (WorkManager, Coroutine) ব্যবহার করো\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ১০. সংক্ষেপে সারাংশ\n" +
                        "\n" +
                        "| পদ্ধতি            | সুবিধা                        | অসুবিধা              |\n" +
                        "| ----------------- | ----------------------------- | -------------------- |\n" +
                        "| HttpURLConnection | বিল্ট-ইন, কাস্টমাইজেশন সম্ভব  | কোড বেশি, জটিল       |\n" +
                        "| Volley            | দ্রুত, সহজ Request Queue      | কিছু সীমাবদ্ধতা আছে  |\n" +
                        "| Retrofit          | সহজ, মডার্ন, Gson ইন্টিগ্রেশন | শিখতে একটু সময় লাগে |\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## \uD83D\uDD25 তোমার জন্য ছোট সারাংশ:\n" +
                        "\n" +
                        "* প্রথমে `AndroidManifest.xml` এ Internet permission দিবে।\n" +
                        "* ব্যাকগ্রাউন্ড থ্রেডে HttpURLConnection বা Volley/Retrofit দিয়ে নেটওয়ার্ক কল করবে।\n" +
                        "* JSON ডেটা পার্স করবে।\n" +
                        "* UI আপডেট করার জন্য `runOnUiThread` বা LiveData/ViewModel ব্যবহার করবে।\n" +
                        "\n"

                      ;
            case "Chapter 9: Final Project":
                return
                        "# \uD83C\uDFAF প্রজেক্ট: Simple News App (API থেকে খবর দেখাবে)\n" +
                        "\n" +
                        "**কি করবে?**\n" +
                        "\n" +
                        "* একটি স্ক্রিন থাকবে যেখানে একটা বাটন থাকবে \"Load News\"\n" +
                        "* বাটন চাপলে ইন্টারনেট থেকে JSON ডেটা নিয়ে আসবে (ফেক API)\n" +
                        "* খবরের শিরোনাম RecyclerView এ দেখাবে\n" +
                        "* একটা নতুন Activity তে খবরের বিস্তারিত দেখাবে\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ধাপ ১: প্রজেক্ট সেটআপ\n" +
                        "\n" +
                        "* Android Studio তে নতুন প্রজেক্ট তৈরি করো\n" +
                        "* Minimum SDK: API 21+\n" +
                        "* Empty Activity (MainActivity)\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ধাপ ২: `build.gradle` (app) ফাইলে যোগ করো\n" +
                        "\n" +
                        "```gradle\n" +
                        "// Retrofit + Gson + RecyclerView + Coroutine (optional)\n" +
                        "implementation 'com.squareup.retrofit2:retrofit:2.9.0'\n" +
                        "implementation 'com.squareup.retrofit2:converter-gson:2.9.0'\n" +
                        "implementation 'androidx.recyclerview:recyclerview:1.2.1'\n" +
                        "implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4'\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ধাপ ৩: Internet পারমিশন যোগ করো `AndroidManifest.xml`\n" +
                        "\n" +
                        "```xml\n" +
                        "<uses-permission android:name=\"android.permission.INTERNET\"/>\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ধাপ ৪: Model Class (NewsItem.kt)\n" +
                        "\n" +
                        "```kotlin\n" +
                        "data class NewsItem(\n" +
                        "    val userId: Int,\n" +
                        "    val id: Int,\n" +
                        "    val title: String,\n" +
                        "    val body: String\n" +
                        ")\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ধাপ ৫: API Interface (ApiService.kt)\n" +
                        "\n" +
                        "```kotlin\n" +
                        "import retrofit2.Call\n" +
                        "import retrofit2.http.GET\n" +
                        "\n" +
                        "interface ApiService {\n" +
                        "    @GET(\"posts\")\n" +
                        "    fun getNews(): Call<List<NewsItem>>\n" +
                        "}\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ধাপ ৬: Retrofit Client (RetrofitClient.kt)\n" +
                        "\n" +
                        "```kotlin\n" +
                        "import retrofit2.Retrofit\n" +
                        "import retrofit2.converter.gson.GsonConverterFactory\n" +
                        "\n" +
                        "object RetrofitClient {\n" +
                        "    private val retrofit = Retrofit.Builder()\n" +
                        "        .baseUrl(\"https://jsonplaceholder.typicode.com/\")\n" +
                        "        .addConverterFactory(GsonConverterFactory.create())\n" +
                        "        .build()\n" +
                        "\n" +
                        "    val apiService: ApiService = retrofit.create(ApiService::class.java)\n" +
                        "}\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ধাপ ৭: RecyclerView Adapter (NewsAdapter.kt)\n" +
                        "\n" +
                        "```kotlin\n" +
                        "import android.view.LayoutInflater\n" +
                        "import android.view.View\n" +
                        "import android.view.ViewGroup\n" +
                        "import android.widget.TextView\n" +
                        "import androidx.recyclerview.widget.RecyclerView\n" +
                        "\n" +
                        "class NewsAdapter(\n" +
                        "    private val newsList: List<NewsItem>,\n" +
                        "    private val onItemClick: (NewsItem) -> Unit\n" +
                        ") : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {\n" +
                        "\n" +
                        "    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {\n" +
                        "        val titleText: TextView = itemView.findViewById(R.id.newsTitle)\n" +
                        "    }\n" +
                        "\n" +
                        "    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {\n" +
                        "        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)\n" +
                        "        return NewsViewHolder(view)\n" +
                        "    }\n" +
                        "\n" +
                        "    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {\n" +
                        "        val news = newsList[position]\n" +
                        "        holder.titleText.text = news.title\n" +
                        "        holder.itemView.setOnClickListener { onItemClick(news) }\n" +
                        "    }\n" +
                        "\n" +
                        "    override fun getItemCount(): Int = newsList.size\n" +
                        "}\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ধাপ ৮: Layout ফাইলগুলো\n" +
                        "\n" +
                        "### `activity_main.xml`\n" +
                        "\n" +
                        "```xml\n" +
                        "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<LinearLayout \n" +
                        "    xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                        "    android:layout_width=\"match_parent\" \n" +
                        "    android:layout_height=\"match_parent\"\n" +
                        "    android:orientation=\"vertical\"\n" +
                        "    android:padding=\"16dp\">\n" +
                        "\n" +
                        "    <Button\n" +
                        "        android:id=\"@+id/btnLoadNews\"\n" +
                        "        android:layout_width=\"match_parent\"\n" +
                        "        android:layout_height=\"wrap_content\"\n" +
                        "        android:text=\"Load News\"/>\n" +
                        "\n" +
                        "    <androidx.recyclerview.widget.RecyclerView\n" +
                        "        android:id=\"@+id/newsRecyclerView\"\n" +
                        "        android:layout_width=\"match_parent\"\n" +
                        "        android:layout_height=\"0dp\"\n" +
                        "        android:layout_weight=\"1\"\n" +
                        "        android:visibility=\"gone\"/>\n" +
                        "</LinearLayout>\n" +
                        "```\n" +
                        "\n" +
                        "### `news_item.xml`\n" +
                        "\n" +
                        "```xml\n" +
                        "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<TextView \n" +
                        "    xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                        "    android:id=\"@+id/newsTitle\"\n" +
                        "    android:layout_width=\"match_parent\"\n" +
                        "    android:layout_height=\"wrap_content\"\n" +
                        "    android:padding=\"12dp\"\n" +
                        "    android:textSize=\"16sp\"\n" +
                        "    android:textColor=\"#000000\"/>\n" +
                        "```\n" +
                        "\n" +
                        "### `activity_detail.xml`\n" +
                        "\n" +
                        "```xml\n" +
                        "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<ScrollView \n" +
                        "    xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                        "    android:layout_width=\"match_parent\" \n" +
                        "    android:layout_height=\"match_parent\"\n" +
                        "    android:padding=\"16dp\">\n" +
                        "\n" +
                        "    <TextView\n" +
                        "        android:id=\"@+id/detailTextView\"\n" +
                        "        android:layout_width=\"match_parent\"\n" +
                        "        android:layout_height=\"wrap_content\"\n" +
                        "        android:textSize=\"18sp\"/>\n" +
                        "</ScrollView>\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ধাপ ৯: MainActivity.kt\n" +
                        "\n" +
                        "```kotlin\n" +
                        "import android.content.Intent\n" +
                        "import android.os.Bundle\n" +
                        "import android.view.View\n" +
                        "import android.widget.Button\n" +
                        "import android.widget.Toast\n" +
                        "import androidx.appcompat.app.AppCompatActivity\n" +
                        "import androidx.recyclerview.widget.LinearLayoutManager\n" +
                        "import androidx.recyclerview.widget.RecyclerView\n" +
                        "import retrofit2.Call\n" +
                        "import retrofit2.Callback\n" +
                        "import retrofit2.Response\n" +
                        "\n" +
                        "class MainActivity : AppCompatActivity() {\n" +
                        "\n" +
                        "    private lateinit var btnLoadNews: Button\n" +
                        "    private lateinit var recyclerView: RecyclerView\n" +
                        "\n" +
                        "    private var newsList = listOf<NewsItem>()\n" +
                        "\n" +
                        "    override fun onCreate(savedInstanceState: Bundle?) {\n" +
                        "        super.onCreate(savedInstanceState)\n" +
                        "        setContentView(R.layout.activity_main)\n" +
                        "\n" +
                        "        btnLoadNews = findViewById(R.id.btnLoadNews)\n" +
                        "        recyclerView = findViewById(R.id.newsRecyclerView)\n" +
                        "        recyclerView.layoutManager = LinearLayoutManager(this)\n" +
                        "\n" +
                        "        btnLoadNews.setOnClickListener {\n" +
                        "            loadNews()\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    private fun loadNews() {\n" +
                        "        btnLoadNews.isEnabled = false\n" +
                        "        RetrofitClient.apiService.getNews().enqueue(object : Callback<List<NewsItem>> {\n" +
                        "            override fun onResponse(call: Call<List<NewsItem>>, response: Response<List<NewsItem>>) {\n" +
                        "                btnLoadNews.isEnabled = true\n" +
                        "                if (response.isSuccessful && response.body() != null) {\n" +
                        "                    newsList = response.body()!!\n" +
                        "                    recyclerView.adapter = NewsAdapter(newsList) { newsItem ->\n" +
                        "                        val intent = Intent(this@MainActivity, DetailActivity::class.java)\n" +
                        "                        intent.putExtra(\"news_body\", newsItem.body)\n" +
                        "                        startActivity(intent)\n" +
                        "                    }\n" +
                        "                    recyclerView.visibility = View.VISIBLE\n" +
                        "                }\n" +
                        "            }\n" +
                        "\n" +
                        "            override fun onFailure(call: Call<List<NewsItem>>, t: Throwable) {\n" +
                        "                btnLoadNews.isEnabled = true\n" +
                        "                Toast.makeText(this@MainActivity, \"Failed to load news\", Toast.LENGTH_SHORT).show()\n" +
                        "            }\n" +
                        "        })\n" +
                        "    }\n" +
                        "}\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ধাপ ১০: DetailActivity.kt\n" +
                        "\n" +
                        "```kotlin\n" +
                        "import android.os.Bundle\n" +
                        "import android.widget.TextView\n" +
                        "import androidx.appcompat.app.AppCompatActivity\n" +
                        "\n" +
                        "class DetailActivity : AppCompatActivity() {\n" +
                        "\n" +
                        "    private lateinit var detailTextView: TextView\n" +
                        "\n" +
                        "    override fun onCreate(savedInstanceState: Bundle?) {\n" +
                        "        super.onCreate(savedInstanceState)\n" +
                        "        setContentView(R.layout.activity_detail)\n" +
                        "\n" +
                        "        detailTextView = findViewById(R.id.detailTextView)\n" +
                        "\n" +
                        "        val newsBody = intent.getStringExtra(\"news_body\")\n" +
                        "        detailTextView.text = newsBody ?: \"No details available\"\n" +
                        "    }\n" +
                        "}\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "## ধাপ ১১: AndroidManifest.xml এ DetailActivity যোগ করো\n" +
                        "\n" +
                        "```xml\n" +
                        "<activity android:name=\".DetailActivity\"></activity>\n" +
                        "```\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "# \uD83D\uDE80 এখন Run করো!\n" +
                        "\n" +
                        "* অ্যাপ লোড হলে \"Load News\" বাটনে চাপো\n" +
                        "* সার্ভার থেকে খবর আসবে তালিকা হিসেবে\n" +
                        "* যে কোনো শিরোনামে ক্লিক করলে বিস্তারিত পেজে নিয়ে যাবে\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "### এই প্রজেক্টে কী কী শিখলে:\n" +
                        "\n" +
                        "* Activity ও Intent ব্যবহার\n" +
                        "* Retrofit দিয়ে নেটওয়ার্ক কল করা\n" +
                        "* JSON ডেটা পার্স করা\n" +
                        "* RecyclerView দিয়ে ডেটা দেখানো\n" +
                        "* ClickListener দিয়ে ইন্টারঅ্যাকশন করা\n" +
                        "\n" +
                        "---\n" +
                        "\n" +
                        "**তোমার ইচ্ছা মতো আরো ফিচার যোগ করতে পারো, যেমন:**\n" +
                        "\n" +
                        "* প্রগ্রেস বার দেখানো\n" +
                        "* Error handling উন্নত করা\n" +
                        "* Pagination করা\n" +
                        "\n"
                 ;
            default:
                return "Content not available for this chapter.";
        }
    }
}
