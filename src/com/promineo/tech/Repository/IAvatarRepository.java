package com.promineo.tech.Repository;

import java.util.ArrayList;

import com.promineo.tech.Models.Avatar;

public interface IAvatarRepository {
	ArrayList<Avatar> getAvatars();
	Avatar getAvatar(int avatarId);
	void createAvatar(Avatar avatar);
	void deleteAvatar(Avatar avatar);
	void updateAvatar(Avatar avatar);
}