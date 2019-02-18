# MultiViewRecycleList
Multiple View/Multiple Object in single recycleview with easy way


A recycle view can contain multiItem and multiview in very easy way.

![alt text](https://github.com/datanapps/MultiViewRecycleList/blob/master/screens/multimedia_1.gif)


# first way
//===============================================================//

# Add all type of adapter in base adapter it will handle automatically.


Just using below dependency and create a sample one.


https://github.com/sockeqwe/AdapterDelegates

 private void createAdapter(){
        baseItemAdapter = new BaseItemAdapter();
        baseItemAdapter.addDelegate(new UsersAdapter());
        baseItemAdapter.addDelegate(new MoviesAdapter());
        baseItemAdapter.addDelegate(new HeaderAdapter());
        baseItemAdapter.addDelegate(new RectHeaderAdapter());
        baseItemAdapter.addFeedItems(getPreparedItemDate());
    }

//===============================================================//
# Second way

Create your own adpter with if else or switch with type.
