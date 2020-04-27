# MultiViewRecycleList
Multiple View/Multiple Object in single recycleview with easy way

A recycle view can contain multiItem and multiview in very easy way.

![alt text](https://github.com/datanapps/MultiViewRecycleList/blob/master/screens/multimedia_1.gif)

There are many way to implement multiview and multiItem in single recycle view but here i want to suggest 2 way.


//===============================================================//
# First way : make your adapter according to your Model/pojo
//===============================================================//

      public class MultiViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
          private List<BaseModel> feedItems;
          private LayoutInflater inflater;

    /*
    * define a constant for identify better
    * */
    final int USER=0;
    final int RECT_HEADER=1;
 
      //============================================ initialise //
          MultiViewAdapter(Context context) {
                          feedItems = new ArrayList<>();
                          inflater = LayoutInflater.from(context);
                      }

      //============================================ Setter Getter//
         public void setFeedItems(List<BaseModel> feedItems) {
               this.feedItems = feedItems;
                    notifyDataSetChanged();
           }

          @Override
           public int getItemCount() {
               return feedItems==null?0:feedItems.size();
          }
                
       //============================================ Get View type according to view Item//
        @Override
        public int getItemViewType(int position) {

        BaseModel baseModel = feedItems.get(position);
        if (baseModel instanceof User) {
            return USER;
        }
        else if (baseModel instanceof RectHeader) {
            return RECT_HEADER;
        }
        return 0;

    }

      //============================================ Get view holder accorcing to view type //
          @Override
          public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
              switch (viewType) {
                  case USER:
                      return new UserViewHolder(inflater.inflate(R.layout.item_layout_user, parent, false));
                  case RECT_HEADER:
                      return new RectHeaderHolder(inflater.inflate(R.layout.item_layout_rect_header, parent, false));
                 }

        return new UserViewHolder(inflater.inflate(R.layout.item_layout_user, parent, false));

    }
      //============================================ Bind view accorcing to view holder //
          @Override
          public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
              switch (holder.getItemViewType()) {
                  case USER:
                      final User user = (User) feedItems.get(position);
                      final UserViewHolder userViewHolder = (UserViewHolder) holder;
                      userViewHolder.userImage.setImageResource(user.getImage());
                      userViewHolder.userName.setText(user.getName());
                      break;

                  case RECT_HEADER:
                      final RectHeader rectHeader = (RectHeader) feedItems.get(position);
                      final RectHeaderHolder rectHeaderHolder = (RectHeaderHolder) holder;
                      rectHeaderHolder.tvRectHeader.setText(rectHeader.getRectHeaderName());
                      rectHeaderHolder.bgView.setBackgroundColor(rectHeader.getRectHeaderBgColorCode());
                      break;

        }
           
    }
    
    // define all view holder here
      //============================================//

    public class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView userName;
        public ImageView userImage;
        public UserViewHolder(View view) {
            super(view);
            userImage = view.findViewById(R.id.img_image_name);
            userName = view.findViewById(R.id.tv_user_name);
        }
    }

    //============================================//

    public class RectHeaderHolder extends RecyclerView.ViewHolder {
        public TextView tvRectHeader;
        public View bgView;
        public RectHeaderHolder(View view) {
            super(view);
            bgView = view;
            tvRectHeader = view.findViewById(R.id.tv_rect_header);
        }
    }


}


//===============================================================//
# Second way :  Add all type of adapter in base adapter it will handle automatically.
//===============================================================//
A sample application can get from delegate package

Using third party   https://github.com/sockeqwe/AdapterDelegates created a example. This is very useful and easy to understand

Just Add differtent item adapter in base adapter. 

      private void createAdapter(){
        baseItemAdapter = new BaseItemAdapter();
            
        baseItemAdapter.addDelegate(new UsersAdapter());
        baseItemAdapter.addDelegate(new MoviesAdapter());
        baseItemAdapter.addDelegate(new HeaderAdapter());
        baseItemAdapter.addDelegate(new RectHeaderAdapter());
        baseItemAdapter.addFeedItems(getPreparedItemDate());
    }
    
//=======================================================//
 # What is best approach:
//=======================================================//
    
 If you want to show small item in recycle view with less action then follow first approach and second approach is good for if your view contain lots of action like click, share, like, bookmark etc.
    
    
    
 [![See](https://datanapps.com/public/dnarestapi/buy/buy_coffee3.png)](https://www.paypal.me/datanappspaynow)

  ### License

Copyright [2020] [datanapps]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
   http://www.apache.org/licenses/LICENSE-2.0

