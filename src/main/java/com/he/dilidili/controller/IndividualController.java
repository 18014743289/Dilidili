package com.he.dilidili.controller;


import com.he.dilidili.common.cache.RequestContext;
import com.he.dilidili.common.result.Result;
import com.he.dilidili.model.dto.*;
import com.he.dilidili.model.vo.CollectVO;
import com.he.dilidili.model.vo.LayoutVO;
import com.he.dilidili.model.vo.PersonalInformationVO;
import com.he.dilidili.model.vo.ProgressVO;
import com.he.dilidili.service.*;
import com.he.dilidili.utils.AIAssistantUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/individual")
@AllArgsConstructor
@Tag(name = "个体运营")
public class IndividualController {
    private final PersonalInformationService personalInformationService;
    private final CommunicationService communicationService;
    private final CommentService commentService;
    private final RelationshipService relationshipService;
    private final NewsService newsService;
    private final CollectionsService collectionsService;
    private final ProductsService musicService;
    private final ApplicationService applicationService;
    private final LikeService likeService;
    private final CollectService collectService;
    private final HistoryService historyService;
    private final LayoutService layoutService;
    private final ProgressService progressService;

    @RequestMapping(value = "/RandomName", method = {RequestMethod.POST})
    @Operation(summary = "获取随机用户名")
    public Result<String> getRandomName(){
        return Result.ok(AIAssistantUtils.createName());
    }
    @RequestMapping(value = "/application", method = {RequestMethod.POST})
    @Operation(summary = "申请身份认证")
    public Result<String> application(@RequestBody ApplicationDTO applicationDTO){
        applicationService.insert(applicationDTO);
        return Result.ok();
    }
    @RequestMapping(value = "/changePhone", method = {RequestMethod.PUT})
    @Operation(summary = "换绑手机号")
    public Result<String> bindPhone(
            @RequestParam("phone") String phone,
            @RequestParam("code") String code,
            @RequestHeader("Authorization") String accessToken)
    {
        return Result.ok(communicationService.bindPhone(phone, code, accessToken));
    }

    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    @Operation(summary = "获取⽤户信息")
    public Result<PersonalInformationVO> getInfo() {
        return Result.ok(personalInformationService.getPersonalInformation(RequestContext.getUserId()));
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    @Operation(summary = "修改⽤户信息")
    public Result<PersonalInformationVO> update(@RequestBody PersonalInformationDTO userEditDTO) {
        return Result.ok(personalInformationService.updatePersonalInformation(userEditDTO));
    }

    @RequestMapping(value = "/avatar", method = {RequestMethod.POST})
    @Operation(summary = "头像上传")
    public Result<String> upload(@RequestBody MultipartFile file) {
        return Result.ok(communicationService.uploadAvatar(file));
    }

    @RequestMapping(value = "/changePassword", method = {RequestMethod.PUT})
    @Operation(summary = "更改密码")
    public Result<String> changePassword(@RequestParam("phone") String phone, @RequestParam("code") String code,
                                         @RequestParam("password") String password, @RequestHeader("Authorization") String accessToken) {
        return Result.ok(communicationService.updatePassword(phone, code, password, accessToken));
    }
//
//    @RequestMapping(value = "/Comment", method = {RequestMethod.POST, RequestMethod.GET})
//    @Operation(summary = "获取评论")
//    public Result<List<CommentVO>> getComment() {
//        return Result.ok(commentService.get());
//    }

//    @RequestMapping(value = "/Fan", method = {RequestMethod.POST, RequestMethod.GET})
//    @Operation(summary = "获取粉丝")
//    public Result<List<RelationshipVO>> getFan() {
//        return Result.ok(relationshipService.getFans());
//    }

//    @RequestMapping(value = "/Followed", method = {RequestMethod.POST, RequestMethod.GET})
//    @Operation(summary = "获取关注")
//    public Result<List<RelationshipVO>> getFollowed() {
//        return Result.ok(relationshipService.getFollows());
//    }

    @RequestMapping(value = "/AddFan", method = {RequestMethod.POST})
    @Operation(summary = "添加粉丝信息")
    public Result<String> addFan(@RequestParam Integer id) {
        relationshipService.addRelationship(id);
        newsService.addNews(id, 2,"您有新的粉丝!");
        return Result.ok();
    }

    @RequestMapping(value = "/DeleteFan", method = {RequestMethod.DELETE})
    @Operation(summary = "删除粉丝信息")
    public Result<String> deleteFan(@RequestParam("id") Integer id) {
        relationshipService.deleteRelationship(id);
        return Result.ok();
    }

//    @RequestMapping(value = "/GetNotification", method = {RequestMethod.GET, RequestMethod.POST})
//    @Operation(summary = "获取通知")
//    public Result<List<NewsVO>> getNotification() {
//        return Result.ok(newsService.getNewsByType());
//    }

    @RequestMapping(value = "/DeleteNotification", method = {RequestMethod.DELETE})
    @Operation(summary = "删除通知")
    public Result<String> deleteNotification(@RequestParam("id") Integer id) {
        newsService.deleteNews(id);
        return Result.ok();
    }

//    @RequestMapping(value = "/Favorites", method = {RequestMethod.GET, RequestMethod.POST})
//    @Operation(summary = "获取收藏")
//    public Result<List<FavoritesVO>> getFavorites() {
//        return Result.ok(collectionsService.getFavorites());
//    }

    @RequestMapping(value = "/AddFavorites", method = {RequestMethod.POST})
    @Operation(summary = "添加收藏")
    public Result<String> addFavorites(@RequestBody CollectionsDTO collectionsDTO) {
        collectionsService.addCollections(collectionsDTO);
        return Result.ok();
    }

    @RequestMapping(value = "/DeleteFavorites", method = {RequestMethod.DELETE})
    @Operation(summary = "删除收藏")
    public Result<String> deleteFavorites(@RequestParam("id") Integer id) {
        collectionsService.cancelCollections(id);
        return Result.ok();
    }

//    TODO 获取收藏夹内容
//    TODO 获取浏览记录
//    TODO 获取激励任务 查询任务进度 更新任务进度

    @RequestMapping(value = "/AddCollect", method = {RequestMethod.POST})
    @Operation(summary = "新建收藏夹")
    public Result<String> addCollect(@RequestBody CollectDTO collectDTO) {
        collectService.add(collectDTO);
        return Result.ok();
    }

    @RequestMapping(value = "/UpdateCollect", method = {RequestMethod.PUT})
    @Operation(summary = "更新收藏夹信息")
    public Result<String> updateCollect(@RequestBody CollectDTO collectDTO) {
        collectService.update(collectDTO);
        return Result.ok();
    }

    @RequestMapping(value = "/DeleteCollect", method = {RequestMethod.DELETE})
    @Operation(summary = "删除收藏夹")
    public Result<String> deleteCollect(@RequestParam("id") Integer id) {
        historyService.deleteHistory(id);
        return Result.ok();
    }

    @RequestMapping(value = "/DeleteHistory", method = {RequestMethod.DELETE})
    @Operation(summary = "删除历史记录")
    public Result<String> deleteHistory(@RequestParam("id") Integer id) {
        collectService.delete(id);
        return Result.ok();
    }

    @RequestMapping(value = "/UpdateLayout", method = {RequestMethod.PUT})
    @Operation(summary = "更新布局")
    public Result<String> updateLayout(@RequestBody LayoutDTO layoutDTO) {
        layoutService.updateLayout(layoutDTO);
        return Result.ok();
    }

    @RequestMapping(value = "/GetLayout", method = {RequestMethod.GET})
    @Operation(summary = "获取布局")
    public Result<LayoutVO> getLayout(@RequestParam ("id") Integer id) {
        return Result.ok( layoutService.getLayout(id));
    }

    @RequestMapping(value = "/ReceiveTask", method = {RequestMethod.POST})
    @Operation(summary = "接受任务")
    public Result<String> receiveTask(@RequestParam ("id") Integer id) {
        progressService.addProgress(id);
        return Result.ok();
    }

    @RequestMapping(value = "/UpdateTask", method = {RequestMethod.PUT})
    @Operation(summary = "更新任务进度")
    public Result<ProgressVO> updateProgress(@RequestParam ("id") Integer id) {
//        TODO
        return Result.ok(progressService.updateProgress(id));
    }
//    @RequestMapping(value = "/GetMyWorks", method = {RequestMethod.GET, RequestMethod.POST})
//    @Operation(summary = "获取个人作品")
//    public Result<List<MusicVO>> getMyWorks() {
//        return Result.ok(musicService.getMusicByAuthorId());
//    }
//
//    @RequestMapping(value = "/SearchMusic", method = {RequestMethod.GET, RequestMethod.POST})
//    @Operation(summary = "用户模糊搜索")
//    public Result<List<MusicVO>> SearchMusic(@RequestParam("keyword") String keyword) {
//        return Result.ok(musicService.getMusicByKeyword(keyword));
//    }

    @RequestMapping(value = "/UpdateProduct", method = {RequestMethod.PUT})
    @Operation(summary = "更新作品状态")
    public Result<String> updateMusic(@RequestBody ProductsDTO productsDTO) {
        musicService.updateProducts(productsDTO);
        return Result.ok();
    }

    @RequestMapping(value = "/UploadProduct", method = {RequestMethod.POST})
    @Operation(summary = "上传作品")
    public Result<String> uploadMusic(@RequestBody ProductsDTO productsDTO) {
        musicService.addProducts(productsDTO);
        return Result.ok();
    }

    @RequestMapping(value = "/AddComment", method = {RequestMethod.POST})
    @Operation(summary = "添加评论")
    public Result<String> addComment(@RequestBody CommentDTO commentDTO) {
        commentService.addComment(commentDTO);
//        TODO 缺少为at条目对象遍历添加通知
        return Result.ok();
    }

    @RequestMapping(value = "/DeleteComment", method = {RequestMethod.DELETE})
    @Operation(summary = "删除评论")
    public Result<String> deleteComment(@RequestParam("id") Integer id) {
        commentService.deleteComment(id);
        return Result.ok();
    }

//    @RequestMapping(value = "/MusicComment", method = {RequestMethod.GET, RequestMethod.POST})
//    @Operation(summary = "获取作品评论")
//    public Result<List<CommentVO>> SearchMusic(@RequestParam("id") Integer id) {
//        return Result.ok(commentService.getCommentByMusicId(id));
//    }
//
    @RequestMapping(value = "/LikesComment", method = {RequestMethod.POST})
    @Operation(summary = "点赞评论")
    public Result<Integer> likesComment(@RequestBody LikeDTO likeDTO) {
        return Result.ok(likeService.addLike(likeDTO));
    }

    @RequestMapping(value = "/DislikesComment", method = {RequestMethod.POST})
    @Operation(summary = "取消点赞评论")
    public Result<String> dislikesComment(@RequestParam ("id") Integer id) {
        likeService.deleteLike(id);
        return Result.ok();
    }

    @RequestMapping(value = "/IsFavorite", method = {RequestMethod.GET})
    @Operation(summary = "判断是否收藏")
    public Result<List<CollectVO>> isFavorite(@RequestParam("id") Integer id) {
        return Result.ok(collectionsService.isCollected(id));
    }
//
//    @RequestMapping(value = "/GetFollowedWorks", method = {RequestMethod.GET, RequestMethod.POST})
//    @Operation(summary = "获取关注作品")
//    public Result<List<MusicVO>> getFollowedWorks(@RequestParam("id") Integer id) {
//        return Result.ok(musicService.getMusicByAuthorId(id));
//    }
//
//    @RequestMapping(value = "/GetAllFollowedWorks", method = {RequestMethod.GET, RequestMethod.POST})
//    @Operation(summary = "获取所有关注的人的作品")
//    public Result<List<MusicVO>> getAllFollowedWorks() {
//        return Result.ok(musicService.getAllFollowedMusic());
//    }
}
