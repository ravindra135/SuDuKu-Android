## Sample Android Codes

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:backgroundTint="#CFBBBB"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/tv_app_name"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="28dp"
        android:layout_marginTop="28dp"
        android:text="@string/app_name"
        android:textSize="20sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="@+id/tv_timer"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/tv_timer"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="28dp"
        android:layout_marginEnd="28dp"
        android:text="@string/time_default"
        android:textSize="20sp"
        android:textStyle="bold"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <RelativeLayout
        android:id="@+id/rl_action_container"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center_horizontal|center_vertical"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent">

        <androidx.appcompat.widget.AppCompatButton
            android:id="@+id/btn1"
            style="@style/ActionButton"
            android:layout_marginTop="14dp"
            android:onClick="actionBtnClicked"
            android:text="1" />

        <androidx.appcompat.widget.AppCompatButton
            android:id="@+id/btn2"
            style="@style/ActionButton"
            android:layout_alignTop="@id/btn1"
            android:layout_marginStart="14dp"
            android:layout_toEndOf="@+id/btn1"
            android:onClick="actionBtnClicked"
            android:tag="Button"
            android:text="2" />

        <androidx.appcompat.widget.AppCompatButton
            android:id="@+id/btn3"
            style="@style/ActionButton"
            android:layout_alignTop="@id/btn1"
            android:layout_marginStart="14dp"
            android:layout_toEndOf="@+id/btn2"
            android:onClick="actionBtnClicked"
            android:text="3" />

        <androidx.appcompat.widget.AppCompatButton
            android:id="@+id/btn4"
            style="@style/ActionButton"
            android:layout_alignTop="@id/btn1"
            android:layout_marginStart="14dp"
            android:layout_toEndOf="@+id/btn3"
            android:onClick="actionBtnClicked"
            android:text="4" />

        <androidx.appcompat.widget.AppCompatButton
            android:id="@+id/btn5"
            style="@style/ActionButton"
            android:layout_alignTop="@id/btn1"
            android:layout_marginStart="14dp"
            android:layout_toEndOf="@+id/btn4"
            android:onClick="actionBtnClicked"
            android:text="5" />

        <androidx.appcompat.widget.AppCompatButton
            android:id="@+id/btn6"
            style="@style/ActionButton"
            android:layout_below="@+id/btn1"
            android:layout_marginVertical="14dp"
            android:onClick="actionBtnClicked"
            android:text="6" />

        <androidx.appcompat.widget.AppCompatButton
            android:id="@+id/btn7"
            style="@style/ActionButton"
            android:layout_alignBottom="@+id/btn6"
            android:layout_marginStart="14dp"
            android:layout_toEndOf="@+id/btn6"
            android:onClick="actionBtnClicked"
            android:text="7" />

        <androidx.appcompat.widget.AppCompatButton
            android:id="@+id/btn8"
            style="@style/ActionButton"
            android:layout_alignBottom="@+id/btn6"
            android:layout_marginStart="14dp"
            android:layout_toEndOf="@+id/btn7"
            android:onClick="actionBtnClicked"
            android:text="8" />

        <androidx.appcompat.widget.AppCompatButton
            android:id="@+id/btn9"
            style="@style/ActionButton"
            android:layout_alignBottom="@+id/btn6"
            android:layout_marginStart="14dp"
            android:layout_toEndOf="@+id/btn8"
            android:onClick="actionBtnClicked"
            android:text="9" />

        <androidx.appcompat.widget.AppCompatImageButton
            android:id="@+id/btnDelete"
            style="@style/ActionButton"
            android:layout_alignBottom="@+id/btn6"
            android:layout_marginStart="14dp"
            android:layout_toEndOf="@+id/btn9"
            android:onClick="actionBtnClicked"
            android:scaleType="centerInside"
            app:srcCompat="@drawable/delete" />

    </RelativeLayout>

    <androidx.gridlayout.widget.GridLayout
        android:background="@drawable/board_border"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:columnCount="3"
        android:layout_marginTop="20dp"
        android:layout_marginHorizontal="20dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/tv_app_name"
        app:rowCount="3">

        <RelativeLayout
            android:id="@+id/rl_0"
            android:padding="2dp"
            android:background="@drawable/board_border"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:layout_row="0"
            app:layout_column="0">

            <TextView
                android:id="@+id/tv_00"
                android:background="@drawable/top_left"
                android:text=""
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_01"
                android:text=""
                android:background="@drawable/bottom"
                android:layout_toEndOf="@id/tv_00"
                android:layout_alignBottom="@id/tv_00"
                style="@style/TableCell" />

            <TextView
                android:id="@+id/tv_02"
                android:background="@drawable/top_right"
                android:text=""
                android:layout_toEndOf="@id/tv_01"
                android:layout_alignBottom="@id/tv_00"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_10"
                android:text=""
                android:background="@drawable/right"
                android:layout_below="@id/tv_00"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_11"
                android:text=""
                android:layout_toEndOf="@id/tv_10"
                android:layout_alignBottom="@id/tv_10"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_12"
                android:text=""
                android:background="@drawable/left"
                android:layout_toEndOf="@id/tv_11"
                android:layout_alignBottom="@id/tv_10"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_20"
                android:text=""
                android:background="@drawable/bottom_left"
                android:layout_below="@id/tv_10"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_21"
                android:text=""
                android:background="@drawable/top"
                android:layout_toEndOf="@id/tv_20"
                android:layout_alignBottom="@id/tv_20"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_22"
                android:text=""
                android:background="@drawable/bottom_right"
                android:layout_toEndOf="@id/tv_21"
                android:layout_alignBottom="@id/tv_20"
                style="@style/TableCell"/>

        </RelativeLayout>

        <RelativeLayout
            android:id="@+id/rl_1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:background="@drawable/board_border"
            android:padding="2dp"
            app:layout_row="0"
            app:layout_column="1">

            <TextView
                android:id="@+id/tv_03"
                style="@style/TableCell"
                android:background="@drawable/top_left"
                android:text="" />

            <TextView
                android:id="@+id/tv_04"
                style="@style/TableCell"
                android:layout_alignBottom="@id/tv_03"
                android:layout_toEndOf="@id/tv_03"
                android:background="@drawable/bottom"
                android:text="" />

            <TextView
                android:id="@+id/tv_05"
                style="@style/TableCell"
                android:layout_alignBottom="@id/tv_03"
                android:layout_toEndOf="@id/tv_04"
                android:background="@drawable/top_right"
                android:text="" />

            <TextView
                android:id="@+id/tv_13"
                style="@style/TableCell"
                android:layout_below="@id/tv_03"
                android:background="@drawable/right"
                android:text="" />

            <TextView
                android:id="@+id/tv_14"
                style="@style/TableCell"
                android:layout_alignBottom="@id/tv_13"
                android:layout_toEndOf="@id/tv_13"
                android:text="" />

            <TextView
                android:id="@+id/tv_15"
                style="@style/TableCell"
                android:layout_alignBottom="@id/tv_13"
                android:layout_toEndOf="@id/tv_14"
                android:background="@drawable/left"
                android:text="" />

            <TextView
                android:id="@+id/tv_23"
                style="@style/TableCell"
                android:layout_below="@id/tv_13"
                android:background="@drawable/bottom_left"
                android:text="" />

            <TextView
                android:id="@+id/tv_24"
                style="@style/TableCell"
                android:layout_alignBottom="@id/tv_23"
                android:layout_toEndOf="@id/tv_23"
                android:background="@drawable/top"
                android:text="" />

            <TextView
                android:id="@+id/tv_25"
                style="@style/TableCell"
                android:layout_alignBottom="@id/tv_23"
                android:layout_toEndOf="@id/tv_24"
                android:background="@drawable/bottom_right"
                android:text="" />

        </RelativeLayout>

        <RelativeLayout
            android:id="@+id/rl_2"
            android:padding="2dp"
            android:background="@drawable/board_border"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:layout_row="0"
            app:layout_column="2">

            <TextView
                android:id="@+id/tv_06"
                android:background="@drawable/top_left"
                android:text=""
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_07"
                android:text=""
                android:background="@drawable/bottom"
                android:layout_toEndOf="@id/tv_06"
                android:layout_alignBottom="@id/tv_06"
                style="@style/TableCell" />

            <TextView
                android:id="@+id/tv_08"
                android:background="@drawable/top_right"
                android:text=""
                android:layout_toEndOf="@id/tv_07"
                android:layout_alignBottom="@id/tv_06"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_16"
                android:text=""
                android:background="@drawable/right"
                android:layout_below="@id/tv_06"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_17"
                android:text=""
                android:layout_toEndOf="@id/tv_16"
                android:layout_alignBottom="@id/tv_16"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_18"
                android:text=""
                android:background="@drawable/left"
                android:layout_toEndOf="@id/tv_17"
                android:layout_alignBottom="@id/tv_16"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_26"
                android:text=""
                android:background="@drawable/bottom_left"
                android:layout_below="@id/tv_16"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_27"
                android:text=""
                android:background="@drawable/top"
                android:layout_toEndOf="@id/tv_26"
                android:layout_alignBottom="@id/tv_26"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_28"
                android:text=""
                android:background="@drawable/bottom_right"
                android:layout_toEndOf="@id/tv_27"
                android:layout_alignBottom="@id/tv_26"
                style="@style/TableCell"/>

        </RelativeLayout>

        <RelativeLayout
            android:id="@+id/rl_3"
            android:padding="2dp"
            android:background="@drawable/board_border"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:layout_row="1"
            app:layout_column="0">

            <TextView
                android:id="@+id/tv_30"
                android:background="@drawable/top_left"
                android:text=""
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_31"
                android:text=""
                android:background="@drawable/bottom"
                android:layout_toEndOf="@id/tv_30"
                android:layout_alignBottom="@id/tv_30"
                style="@style/TableCell" />

            <TextView
                android:id="@+id/tv_32"
                android:background="@drawable/top_right"
                android:text=""
                android:layout_toEndOf="@id/tv_31"
                android:layout_alignBottom="@id/tv_30"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_40"
                android:text=""
                android:background="@drawable/right"
                android:layout_below="@id/tv_30"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_41"
                android:text=""
                android:layout_toEndOf="@id/tv_40"
                android:layout_alignBottom="@id/tv_40"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_42"
                android:text=""
                android:background="@drawable/left"
                android:layout_toEndOf="@id/tv_41"
                android:layout_alignBottom="@id/tv_40"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_50"
                android:text=""
                android:background="@drawable/bottom_left"
                android:layout_below="@id/tv_40"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_51"
                android:text=""
                android:background="@drawable/top"
                android:layout_toEndOf="@id/tv_50"
                android:layout_alignBottom="@id/tv_50"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_52"
                android:text=""
                android:background="@drawable/bottom_right"
                android:layout_toEndOf="@id/tv_51"
                android:layout_alignBottom="@id/tv_50"
                style="@style/TableCell"/>

        </RelativeLayout>

        <RelativeLayout
            android:id="@+id/rl_4"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:background="@drawable/board_border"
            android:padding="2dp"
            app:layout_row="1"
            app:layout_column="1">

            <TextView
                android:id="@+id/tv_33"
                style="@style/TableCell"
                android:background="@drawable/top_left"
                android:text="" />

            <TextView
                android:id="@+id/tv_34"
                style="@style/TableCell"
                android:layout_alignBottom="@id/tv_33"
                android:layout_toEndOf="@id/tv_33"
                android:background="@drawable/bottom"
                android:text="" />

            <TextView
                android:id="@+id/tv_35"
                style="@style/TableCell"
                android:layout_alignBottom="@id/tv_33"
                android:layout_toEndOf="@id/tv_34"
                android:background="@drawable/top_right"
                android:text="" />

            <TextView
                android:id="@+id/tv_43"
                style="@style/TableCell"
                android:layout_below="@id/tv_33"
                android:background="@drawable/right"
                android:text="" />

            <TextView
                android:id="@+id/tv_44"
                style="@style/TableCell"
                android:layout_alignBottom="@id/tv_43"
                android:layout_toEndOf="@id/tv_43"
                android:text="" />

            <TextView
                android:id="@+id/tv_45"
                style="@style/TableCell"
                android:layout_alignBottom="@id/tv_43"
                android:layout_toEndOf="@id/tv_44"
                android:background="@drawable/left"
                android:text="" />

            <TextView
                android:id="@+id/tv_53"
                style="@style/TableCell"
                android:layout_below="@id/tv_43"
                android:background="@drawable/bottom_left"
                android:text="" />

            <TextView
                android:id="@+id/tv_54"
                style="@style/TableCell"
                android:layout_alignBottom="@id/tv_53"
                android:layout_toEndOf="@id/tv_53"
                android:background="@drawable/top"
                android:text="" />

            <TextView
                android:id="@+id/tv_55"
                style="@style/TableCell"
                android:layout_alignBottom="@id/tv_53"
                android:layout_toEndOf="@id/tv_54"
                android:background="@drawable/bottom_right"
                android:text="" />

        </RelativeLayout>

        <RelativeLayout
            android:id="@+id/rl_5"
            android:padding="2dp"
            android:background="@drawable/board_border"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:layout_row="1"
            app:layout_column="2">

            <TextView
                android:id="@+id/tv_36"
                android:background="@drawable/top_left"
                android:text=""
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_37"
                android:text=""
                android:background="@drawable/bottom"
                android:layout_toEndOf="@id/tv_36"
                android:layout_alignBottom="@id/tv_36"
                style="@style/TableCell" />

            <TextView
                android:id="@+id/tv_38"
                android:background="@drawable/top_right"
                android:text=""
                android:layout_toEndOf="@id/tv_37"
                android:layout_alignBottom="@id/tv_36"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_46"
                android:text=""
                android:background="@drawable/right"
                android:layout_below="@id/tv_36"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_47"
                android:text=""
                android:layout_toEndOf="@id/tv_46"
                android:layout_alignBottom="@id/tv_46"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_48"
                android:text=""
                android:background="@drawable/left"
                android:layout_toEndOf="@id/tv_47"
                android:layout_alignBottom="@id/tv_46"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_56"
                android:text=""
                android:background="@drawable/bottom_left"
                android:layout_below="@id/tv_46"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_57"
                android:text=""
                android:background="@drawable/top"
                android:layout_toEndOf="@id/tv_56"
                android:layout_alignBottom="@id/tv_56"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_58"
                android:text=""
                android:background="@drawable/bottom_right"
                android:layout_toEndOf="@id/tv_57"
                android:layout_alignBottom="@id/tv_56"
                style="@style/TableCell"/>

        </RelativeLayout>

        <RelativeLayout
            android:id="@+id/rl_6"
            android:padding="2dp"
            android:background="@drawable/board_border"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:layout_row="2"
            app:layout_column="0">

            <TextView
                android:id="@+id/tv_60"
                android:background="@drawable/top_left"
                android:text=""
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_61"
                android:text=""
                android:background="@drawable/bottom"
                android:layout_toEndOf="@id/tv_60"
                android:layout_alignBottom="@id/tv_60"
                style="@style/TableCell" />

            <TextView
                android:id="@+id/tv_62"
                android:background="@drawable/top_right"
                android:text=""
                android:layout_toEndOf="@id/tv_61"
                android:layout_alignBottom="@id/tv_60"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_70"
                android:text=""
                android:background="@drawable/right"
                android:layout_below="@id/tv_60"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_71"
                android:text=""
                android:layout_toEndOf="@id/tv_70"
                android:layout_alignBottom="@id/tv_70"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_72"
                android:text=""
                android:background="@drawable/left"
                android:layout_toEndOf="@id/tv_71"
                android:layout_alignBottom="@id/tv_70"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_80"
                android:text=""
                android:background="@drawable/bottom_left"
                android:layout_below="@id/tv_70"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_81"
                android:text=""
                android:background="@drawable/top"
                android:layout_toEndOf="@id/tv_80"
                android:layout_alignBottom="@id/tv_80"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_82"
                android:text=""
                android:background="@drawable/bottom_right"
                android:layout_toEndOf="@id/tv_81"
                android:layout_alignBottom="@id/tv_80"
                style="@style/TableCell"/>

        </RelativeLayout>

        <RelativeLayout
            android:id="@+id/rl_7"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:background="@drawable/board_border"
            android:padding="2dp"
            app:layout_row="2"
            app:layout_column="1">

            <TextView
                android:id="@+id/tv_63"
                style="@style/TableCell"
                android:background="@drawable/top_left"
                android:text="" />

            <TextView
                android:id="@+id/tv_64"
                style="@style/TableCell"
                android:layout_alignBottom="@id/tv_63"
                android:layout_toEndOf="@id/tv_63"
                android:background="@drawable/bottom"
                android:text="" />

            <TextView
                android:id="@+id/tv_65"
                style="@style/TableCell"
                android:layout_alignBottom="@id/tv_63"
                android:layout_toEndOf="@id/tv_64"
                android:background="@drawable/top_right"
                android:text="" />

            <TextView
                android:id="@+id/tv_73"
                style="@style/TableCell"
                android:layout_below="@id/tv_63"
                android:background="@drawable/right"
                android:text="" />

            <TextView
                android:id="@+id/tv_74"
                style="@style/TableCell"
                android:layout_alignBottom="@id/tv_73"
                android:layout_toEndOf="@id/tv_73"
                android:text="" />

            <TextView
                android:id="@+id/tv_75"
                style="@style/TableCell"
                android:layout_alignBottom="@id/tv_73"
                android:layout_toEndOf="@id/tv_74"
                android:background="@drawable/left"
                android:text="" />

            <TextView
                android:id="@+id/tv_83"
                style="@style/TableCell"
                android:layout_below="@id/tv_73"
                android:background="@drawable/bottom_left"
                android:text="" />

            <TextView
                android:id="@+id/tv_84"
                style="@style/TableCell"
                android:layout_alignBottom="@id/tv_83"
                android:layout_toEndOf="@id/tv_83"
                android:background="@drawable/top"
                android:text="" />

            <TextView
                android:id="@+id/tv_85"
                style="@style/TableCell"
                android:layout_alignBottom="@id/tv_83"
                android:layout_toEndOf="@id/tv_84"
                android:background="@drawable/bottom_right"
                android:text="" />

        </RelativeLayout>

        <RelativeLayout
            android:id="@+id/rl_8"
            android:padding="2dp"
            android:background="@drawable/board_border"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:layout_row="2"
            app:layout_column="2">

            <TextView
                android:id="@+id/tv_66"
                android:background="@drawable/top_left"
                android:text=""
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_67"
                android:text=""
                android:background="@drawable/bottom"
                android:layout_toEndOf="@id/tv_66"
                android:layout_alignBottom="@id/tv_66"
                style="@style/TableCell" />

            <TextView
                android:id="@+id/tv_68"
                android:background="@drawable/top_right"
                android:text=""
                android:layout_toEndOf="@id/tv_67"
                android:layout_alignBottom="@id/tv_66"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_76"
                android:text=""
                android:background="@drawable/right"
                android:layout_below="@id/tv_66"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_77"
                android:text=""
                android:layout_toEndOf="@id/tv_76"
                android:layout_alignBottom="@id/tv_76"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_78"
                android:text=""
                android:background="@drawable/left"
                android:layout_toEndOf="@id/tv_77"
                android:layout_alignBottom="@id/tv_76"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_86"
                android:text=""
                android:background="@drawable/bottom_left"
                android:layout_below="@id/tv_76"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_87"
                android:text=""
                android:background="@drawable/top"
                android:layout_toEndOf="@id/tv_86"
                android:layout_alignBottom="@id/tv_86"
                style="@style/TableCell"/>

            <TextView
                android:id="@+id/tv_88"
                android:text=""
                android:background="@drawable/bottom_right"
                android:layout_toEndOf="@id/tv_87"
                android:layout_alignBottom="@id/tv_86"
                style="@style/TableCell"/>

        </RelativeLayout>

    </androidx.gridlayout.widget.GridLayout>


    <!--    <TableLayout-->
<!--        android:background="@drawable/board_border"-->
<!--        android:id="@+id/tl_main_board"-->
<!--        android:layout_width="match_parent"-->
<!--        android:layout_height="wrap_content"-->
<!--        android:layout_marginStart="28dp"-->
<!--        android:layout_marginEnd="28dp"-->
<!--        android:layout_marginTop="28dp"-->
<!--        app:layout_constraintBottom_toTopOf="@+id/rl_action_container"-->
<!--        app:layout_constraintEnd_toEndOf="parent"-->
<!--        app:layout_constraintHorizontal_bias="0.498"-->
<!--        app:layout_constraintStart_toStartOf="parent"-->
<!--        app:layout_constraintTop_toBottomOf="@+id/tv_app_name"-->
<!--        app:layout_constraintVertical_bias="0.111">-->

<!--        <TableRow-->
<!--            android:layout_width="match_parent"-->
<!--            android:id="@+id/tableRow1"-->
<!--            android:layout_height="wrap_content">-->

<!--            <androidx.fragment.app.FragmentContainerView-->
<!--                android:id="@+id/grid1"-->
<!--                android:layout_width="match_parent"-->
<!--                android:layout_height="wrap_content"-->
<!--                android:name="com.rcube.suduku.GridGroup"-->
<!--                android:layout_weight="1"-->
<!--                android:tag="1"-->
<!--                />-->

<!--            <androidx.fragment.app.FragmentContainerView-->
<!--                android:id="@+id/grid2"-->
<!--                android:layout_width="match_parent"-->
<!--                android:layout_height="wrap_content"-->
<!--                android:name="com.rcube.suduku.GridGroup"-->
<!--                android:layout_weight="1"-->
<!--                android:tag="2"-->
<!--                />-->

<!--            <androidx.fragment.app.FragmentContainerView-->
<!--                android:id="@+id/grid3"-->
<!--                android:layout_width="match_parent"-->
<!--                android:layout_height="wrap_content"-->
<!--                android:name="com.rcube.suduku.GridGroup"-->
<!--                android:layout_weight="1"-->
<!--                android:tag="3"-->
<!--                />-->

<!--        </TableRow>-->

<!--        <TableRow-->
<!--            android:layout_width="match_parent"-->
<!--            android:id="@+id/tableRow2"-->
<!--            android:layout_height="wrap_content">-->

<!--            <androidx.fragment.app.FragmentContainerView-->
<!--                android:id="@+id/grid4"-->
<!--                android:layout_width="match_parent"-->
<!--                android:layout_height="wrap_content"-->
<!--                android:name="com.rcube.suduku.GridGroup"-->
<!--                android:layout_weight="1"-->
<!--                android:tag="4"-->
<!--                />-->

<!--            <androidx.fragment.app.FragmentContainerView-->
<!--                android:id="@+id/grid5"-->
<!--                android:layout_width="match_parent"-->
<!--                android:layout_height="wrap_content"-->
<!--                android:name="com.rcube.suduku.GridGroup"-->
<!--                android:layout_weight="1"-->
<!--                android:tag="5"-->
<!--                />-->

<!--            <androidx.fragment.app.FragmentContainerView-->
<!--                android:id="@+id/grid6"-->
<!--                android:layout_width="match_parent"-->
<!--                android:layout_height="wrap_content"-->
<!--                android:name="com.rcube.suduku.GridGroup"-->
<!--                android:layout_weight="1"-->
<!--                android:tag="6"-->
<!--                />-->

<!--        </TableRow>-->

<!--        <TableRow-->
<!--            android:layout_width="match_parent"-->
<!--            android:id="@+id/tableRow3"-->
<!--            android:layout_height="wrap_content">-->

<!--            <androidx.fragment.app.FragmentContainerView-->
<!--                android:id="@+id/grid7"-->
<!--                android:layout_width="match_parent"-->
<!--                android:layout_height="wrap_content"-->
<!--                android:name="com.rcube.suduku.GridGroup"-->
<!--                android:layout_weight="1"-->
<!--                android:tag="7"-->
<!--                />-->

<!--            <androidx.fragment.app.FragmentContainerView-->
<!--                android:id="@+id/grid8"-->
<!--                android:layout_width="match_parent"-->
<!--                android:layout_height="wrap_content"-->
<!--                android:name="com.rcube.suduku.GridGroup"-->
<!--                android:layout_weight="1"-->
<!--                android:tag="8"-->
<!--                />-->

<!--            <androidx.fragment.app.FragmentContainerView-->
<!--                android:id="@+id/grid9"-->
<!--                android:layout_width="match_parent"-->
<!--                android:layout_height="wrap_content"-->
<!--                android:name="com.rcube.suduku.GridGroup"-->
<!--                android:layout_weight="1"-->
<!--                android:tag="9"-->
<!--                />-->

<!--        </TableRow>-->
<!--    </TableLayout>-->

</androidx.constraintlayout.widget.ConstraintLayout>
```