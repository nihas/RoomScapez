package com.room.scapez.fragments;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.room.scapez.CityAdapter;
import com.room.scapez.MyAdapter;
import com.room.scapez.Person;
import com.room.scapez.R;
import com.room.scapez.adapter.CitiesAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Nihas on 07-May-15.
 */
// In this case, the fragment displays simple text based on the page
public class CityFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private static final int REQUEST_CAMERA = 1;
    //private static final int PICK_FROM_CAMERA = 1;
    private static final int CROP_FROM_CAMERA = 2;
    private static final int PICK_FROM_FILE = 3;

    private int mPage;
    List<Person> persons;
   // ImageSaver sav;
    private Point mSize;
    static int imageStatus=0;
//   ObservableRecyclerView mRecyclerView;
   RecyclerView mRecyclerView;
    public static final String ARG_SCROLL_Y = "ARG_SCROLL_Y";
    private View headerView;
//    private RapidFloatingActionButtonctionLayout rfaLayout;
//    private RapidFloatingActionButton rfaButton;
//    private RapidFloatingActionHelper rfabHelper;
//    ImageView send;
//    ImageView delete1,delete2,delete3;
//    SquareImageView pic1,pic2,pic3,nullPic1,nullPic2,nullPic3;
//    LinearLayout imageLayout;
//    RelativeLayout picRelative1,picRelative2,picRelative3;

    public static CityFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        CityFragment fragment = new CityFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        mSize = new Point();
        display.getSize(mSize);

    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.city_layout, container, false);
//        headerView = view.findViewById(R.id.header);
//        ViewCompat.setElevation(headerView, 48);
//        final Animation animIn = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in);
//        final Animation animOut = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out);

//        rfaLayout=(RapidFloatingActionLayout)view.findViewById(R.id.label_list_sample_rfal);
//        rfaButton=(RapidFloatingActionButton)view.findViewById(R.id.label_list_sample_rfab);
//        imageLayout=(LinearLayout)view.findViewById(R.id.imageLayout);
//        imageLayout.setVisibility(View.GONE);
//        delete1=(ImageView)view.findViewById(R.id.delete1);
//        delete2=(ImageView)view.findViewById(R.id.delete2);
//        delete3=(ImageView)view.findViewById(R.id.delete3);
//        pic1=(SquareImageView)view.findViewById(R.id.picImage1);
//        pic2=(SquareImageView)view.findViewById(R.id.picImage2);
//        pic3=(SquareImageView)view.findViewById(R.id.picImage3);
//        picRelative1=(RelativeLayout)view.findViewById(R.id.picImageRelative1);
//        picRelative2=(RelativeLayout)view.findViewById(R.id.picImageRelative2);
//        picRelative3=(RelativeLayout)view.findViewById(R.id.picImageRelative3);
//        nullPic1=(SquareImageView)view.findViewById(R.id.nullImage1);
//        nullPic2=(SquareImageView)view.findViewById(R.id.nullImage2);
//        nullPic3=(SquareImageView)view.findViewById(R.id.nullImage3);
//        sav=new ImageSaver();
//        UpdateView();
        mRecyclerView=(RecyclerView)view.findViewById(R.id.recyclerView);
//        send=(ImageView)view.findViewById(R.id.send);
//        send.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(imageStatus==0) {
//                    imageLayout.setVisibility(View.VISIBLE);
//                    UpdateView();
//                    nullPic1.setAnimation(animIn);
//                    nullPic2.setAnimation(animIn);
//                    nullPic3.setAnimation(animIn);
//                    pic1.setAnimation(animIn);
//                    pic2.setAnimation(animIn);
//                    pic3.setAnimation(animIn);
//                    imageStatus=1;
//                }else{
//                    imageStatus=0;
//                    UpdateView();
//                    nullPic1.setAnimation(animOut);
//                    nullPic2.setAnimation(animOut);
//                    nullPic3.setAnimation(animOut);
//                    pic1.setAnimation(animOut);
//                    pic2.setAnimation(animOut);
//                    pic3.setAnimation(animOut);
//                    animOut.setAnimationListener(new Animation.AnimationListener() {
//                        @Override
//                        public void onAnimationStart(Animation animation) {
//
//                        }
//
//                        @Override
//                        public void onAnimationEnd(Animation animation) {
//                            imageLayout.setVisibility(View.GONE);
//                        }
//
//                        @Override
//                        public void onAnimationRepeat(Animation animation) {
//
//                        }
//                    });
//                }
//            }
//        });
        initializeData();
//        final ObservableRecyclerView mRecyclerView = (ObservableRecyclerView) view.findViewById(R.id.rv);
//        com.github.ksoichiro.android.observablescrollview.ScrollUtils.addOnGlobalLayoutListener(mRecyclerView, new Runnable() {
//            @Override
//            public void run() {
//                int count = mRecyclerView.getAdapter().getItemCount() - 1;
//                int position = count == 0 ? 1 : count > 0 ? count : 0;
//                mRecyclerView.scrollToPosition(position);
//            }
//        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(false);

//        RapidFloatingActionContentLabelList rfaContent = new RapidFloatingActionContentLabelList(getActivity());
//        rfaContent.setOnRapidFloatingActionContentLabelListListener(new RapidFloatingActionContentLabelList.OnRapidFloatingActionContentLabelListListener() {
//            @Override
//            public void onRFACItemLabelClick(int position, RFACLabelItem item) {
//                //Toast.makeText(getActivity(),"clicked label: " + position,Toast.LENGTH_SHORT).show();
//                switch (position){
//                    case 0:
//                        Intent startCustomCameraIntent = new Intent(getActivity(), hiddle.myapp.com.hiddle.camera.CameraActivity.class);
//                        startActivityForResult(startCustomCameraIntent, REQUEST_CAMERA);
//                        break;
//                    case 1:
//                        break;
//                    case 3:
//                        break;
//                    case 4:
//                        break;
//                    default:
//                        break;
//                }
//                rfabHelper.toggleContent();
//            }
//
//            @Override
//            public void onRFACItemIconClick(int position, RFACLabelItem item) {
//                //Toast.makeText(getActivity(),"clicked icon: " + position,Toast.LENGTH_SHORT).show();
//                switch (position){
//                    case 0:
//                        Intent startCustomCameraIntent = new Intent(getActivity(),hiddle.myapp.com.hiddle.camera.CameraActivity.class);
//                        startActivityForResult(startCustomCameraIntent, REQUEST_CAMERA);
//                        break;
//                    case 1:
//                        break;
//                    case 3:
//                        break;
//                    case 4:
//                        break;
//                    default:
//                        break;
//                }
//                rfabHelper.toggleContent();
//            }
//        });
//        List<RFACLabelItem> items = new ArrayList<>();
//        items.add(new RFACLabelItem<Integer>()
//                        .setLabel("Upload photo")
//                        .setResId(R.mipmap.icon_camera)
//                        .setIconNormalColor(0xffd84315)
//                        .setIconPressedColor(0xffbf360c)
//                        .setWrapper(0)
//        );
//        items.add(new RFACLabelItem<Integer>()
//                        .setLabel("tiantian.china.2@gmail.com")
////                        .setResId(R.mipmap.ico_test_c)
//                        .setDrawable(getResources().getDrawable(R.mipmap.ic_flash))
//                        .setIconNormalColor(0xff4e342e)
//                        .setIconPressedColor(0xff3e2723)
//                        .setLabelColor(Color.WHITE)
//                        .setLabelSizeSp(14)
//                        .setLabelBackgroundDrawable(ABShape.generateCornerShapeDrawable(0xaa000000, ABTextUtil.dip2px(getActivity(), 4)))
//                        .setWrapper(1)
//        );
//        items.add(new RFACLabelItem<Integer>()
//                        .setLabel("WangJie")
//                        .setResId(R.mipmap.ic_flash)
//                        .setIconNormalColor(0xff056f00)
//                        .setIconPressedColor(0xff0d5302)
//                        .setLabelColor(0xff056f00)
//                        .setWrapper(2)
//        );
//        items.add(new RFACLabelItem<Integer>()
//                        .setLabel("Compose")
//                        .setResId(R.mipmap.ic_flash)
//                        .setIconNormalColor(0xff283593)
//                        .setIconPressedColor(0xff1a237e)
//                        .setLabelColor(0xff283593)
//                        .setWrapper(3)
//        );
//        rfaContent
//                .setItems(items)
//                .setIconShadowRadius(ABTextUtil.dip2px(getActivity(), 5))
//                .setIconShadowColor(0xff888888)
//                .setIconShadowDy(ABTextUtil.dip2px(getActivity(), 5))
//        ;
//
//        rfabHelper = new RapidFloatingActionHelper(
//                getActivity(),
//                rfaLayout,
//                rfaButton,
//                rfaContent
//        ).build();

//        mRecyclerView.setScrollViewCallbacks(new com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks() {
//            @Override
//            public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
//                int toolbarHeight = HiddleActivity.mToolbarView.getHeight();
//                if (dragging || scrollY < toolbarHeight) {
//                    if (firstScroll) {
//                        float currentHeaderTranslationY = ViewHelper.getTranslationY(HiddleActivity.mHeaderView);
//                        float currentHeaderTranslationY2 = ViewHelper.getTranslationY(headerView);
//                        if (-toolbarHeight < currentHeaderTranslationY && toolbarHeight < scrollY) {
//                            HiddleActivity.mBaseTranslationY = scrollY;
//                        }
//
//                    }
//                    float headerTranslationY = com.github.ksoichiro.android.observablescrollview.ScrollUtils.getFloat(-(scrollY - HiddleActivity.mBaseTranslationY), -toolbarHeight, 0);
//                    ViewPropertyAnimator.animate(HiddleActivity.mHeaderView).cancel();
//                    ViewHelper.setTranslationY(HiddleActivity.mHeaderView, headerTranslationY);
//                    ViewPropertyAnimator.animate(headerView).cancel();
//                    ViewHelper.setTranslationY(headerView, headerTranslationY);
//                }
//            }
//
//            @Override
//            public void onDownMotionEvent() {
//
//            }
//
//            @Override
//            public void onUpOrCancelMotionEvent(com.github.ksoichiro.android.observablescrollview.ScrollState scrollState) {
//                HiddleActivity.mBaseTranslationY = 0;
//
//                float headerTranslationY = ViewHelper.getTranslationY(HiddleActivity.mHeaderView);
//                int toolbarHeight = HiddleActivity.mToolbarView.getHeight();
//                if (scrollState == com.github.ksoichiro.android.observablescrollview.ScrollState.UP) {
//                    if (toolbarHeight < mRecyclerView.getCurrentScrollY()) {
//                        if (headerTranslationY != -toolbarHeight) {
//                            ViewPropertyAnimator.animate(HiddleActivity.mHeaderView).cancel();
//                            ViewPropertyAnimator.animate(HiddleActivity.mHeaderView).translationY(-toolbarHeight).setDuration(200).start();
//                            ViewPropertyAnimator.animate(headerView).cancel();
//                            ViewPropertyAnimator.animate(headerView).translationY(-toolbarHeight).setDuration(200).start();
//                        }
//                    }
//                } else if (scrollState == com.github.ksoichiro.android.observablescrollview.ScrollState.DOWN) {
//                    if (toolbarHeight < mRecyclerView.getCurrentScrollY()) {
//                        if (headerTranslationY != 0) {
//                            ViewPropertyAnimator.animate(HiddleActivity.mHeaderView).cancel();
//                            ViewPropertyAnimator.animate(HiddleActivity.mHeaderView).translationY(0).setDuration(200).start();
//                            ViewPropertyAnimator.animate(headerView).cancel();
//                            ViewPropertyAnimator.animate(headerView).translationY(0).setDuration(200).start();
//                        }
//                    }
//                }
//            }
//        });

        CityAdapter adapter = new CityAdapter(persons);
        mRecyclerView.setAdapter(adapter);
        //TextView sam = (TextView) view.findViewById(R.id.sample);
        //Button suu = (Button) view.findViewById(R.id.check);

//        suu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ImageSaver sav=new ImageSaver();
//                System.out.println("1 is"+sav.getImage1());
//                System.out.println("2 is"+sav.getImage2());
//                System.out.println("3 is"+sav.getImage3());
//            }
//        });
//        sam.setText("Under Construction");
        //img.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
        //getActivity().setTitle("PAGE 2");
       // tvTitle.setTextSize(30);
       // tvTitle.setText("Fragment #" + mPage);



        return view;
    }

//    public void UpdateView(){
//        if (sav.getImage1()!=null){
//            Bitmap bitmap = ImageUtility.decodeSampledBitmapFromPath(sav.getImage1().getPath(), mSize.x, mSize.x);
//            pic1.setImageBitmap(bitmap);
//            pic1.setVisibility(View.VISIBLE);
//            picRelative1.setVisibility(View.VISIBLE);
//            delete1.setVisibility(View.VISIBLE);
//            nullPic1.setVisibility(View.GONE);
//        }else {
//            pic1.setVisibility(View.GONE);
//            picRelative1.setVisibility(View.GONE);
//            nullPic1.setVisibility(View.VISIBLE);
//            delete1.setVisibility(View.GONE);
//        }
//        if (sav.getImage2()!=null){
//            Bitmap bitmap = ImageUtility.decodeSampledBitmapFromPath(sav.getImage2().getPath(), mSize.x, mSize.x);
//            pic2.setImageBitmap(bitmap);
//            pic2.setVisibility(View.VISIBLE);
//            picRelative2.setVisibility(View.VISIBLE);
//            delete2.setVisibility(View.VISIBLE);
//            nullPic2.setVisibility(View.GONE);
//        }else {
//            pic2.setVisibility(View.GONE);
//            picRelative2.setVisibility(View.GONE);
//            nullPic2.setVisibility(View.VISIBLE);
//            delete2.setVisibility(View.GONE);
//        }
//        if (sav.getImage3()!=null){
//            Bitmap bitmap = ImageUtility.decodeSampledBitmapFromPath(sav.getImage3().getPath(), mSize.x, mSize.x);
//            pic3.setImageBitmap(bitmap);
//            pic3.setVisibility(View.VISIBLE);
//            picRelative3.setVisibility(View.VISIBLE);
//            delete3.setVisibility(View.VISIBLE);
//            nullPic3.setVisibility(View.GONE);
//        }else {
//            pic3.setVisibility(View.GONE);
//            picRelative3.setVisibility(View.GONE);
//            nullPic3.setVisibility(View.VISIBLE);
//            delete3.setVisibility(View.GONE);
//        }
//    }



    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", ""));
        persons.add(new Person("Lavery Maiss", "25 years old", ""));
        persons.add(new Person("Lillie Watts", "35 years old", ""));
        persons.add(new Person("Emma Wilson", "23 years old", ""));
        persons.add(new Person("Lavery Maiss", "25 years old", ""));
        persons.add(new Person("Lillie Watts", "35 years old",""));
        persons.add(new Person("Emma Wilson", "23 years old", ""));
        persons.add(new Person("Lavery Maiss", "25 years old",""));
        persons.add(new Person("Lillie Watts", "35 years old", ""));
    }


}