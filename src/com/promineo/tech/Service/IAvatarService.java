  
package com.promineo.tech.Service;

import java.util.ArrayList;

import com.promineo.tech.Models.Avatar;

public interface IAvatarService {
	ArrayList<Avatar> getAvatars();
	Avatar getAvatar(int avatarId);
	void createAvatar(Avatar avatar);
	void deleteAvatar(Avatar avatar);
	void updateAvatar(Avatar avatar);
}