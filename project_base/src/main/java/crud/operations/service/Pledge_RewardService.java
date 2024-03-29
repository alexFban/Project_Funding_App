package crud.operations.service;

import crud.operations.entity.Pledge_Reward;

import java.util.List;

public interface Pledge_RewardService {
    Pledge_Reward createPledge_Reward(Pledge_Reward pledgeReward);
    Pledge_Reward getPledge_RewardById(Long pledgeRewardId);
    List<Pledge_Reward> getAllPledge_Rewards();
    Pledge_Reward updatePledge_Reward(Pledge_Reward pledgeReward);
    void deletePledge_Reward(Long pledgeRewardId);
}
