package com.promineo.tech.Service;



import com.promineo.tech.Models.Race;

import java.util.ArrayList;

import com.promineo.tech.Models.Avatar;
import com.promineo.tech.Repository.AvatarRepository;

public class AvatarService implements IAvatarService {
private AvatarRepository avatarRepository;
	
	public AvatarService()
	{
		avatarRepository = new AvatarRepository();
	}
	
	@Override
	public ArrayList<Avatar> getAvatars()
	{
		return avatarRepository.getAvatars();
	}

	@Override
	public Avatar getAvatar(int avatarId) {
		return avatarRepository.getAvatar(avatarId);
	}

	@Override
	public void createAvatar(Avatar avatar) {
		avatarRepository.createAvatar(avatar);
	}

	@Override
	public void deleteAvatar(Avatar avatar) {
		avatarRepository.deleteAvatar(avatar);
	}
	
	@Override
	public void updateAvatar(Avatar avatar) {
		avatarRepository.updateAvatar(avatar);
	}
}