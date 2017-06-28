package com.niit.collabbackend.DAO;

import java.util.List;

import com.niit.collabbackend.model.Friend;

public interface FriendDAO {

	public boolean addOrUpdateFriend(Friend friend);

	public boolean deleteFriend(Friend friend);

	public List<Friend> getListOfFriend();

	public Friend getParticularFriend(int friend_id);

}
