/*    */ package com.bioxx.tfc.Handlers.Client;
/*    */ 
/*    */ import com.bioxx.tfc.Core.Player.InventoryPlayerTFC;
/*    */ import com.bioxx.tfc.Render.RenderLargeItem;
/*    */ import com.bioxx.tfc.Render.RenderQuiver;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import cpw.mods.fml.common.gameevent.PlayerEvent;
/*    */ import cpw.mods.fml.common.gameevent.TickEvent;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.client.event.RenderPlayerEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerRenderHandler
/*    */ {
/* 22 */   public static final RenderQuiver RENDER_QUIVER = new RenderQuiver();
/* 23 */   public static final RenderLargeItem RENDER_LARGE = new RenderLargeItem();
/*    */   
/*    */   @SubscribeEvent
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void onPlayerRenderTick(RenderPlayerEvent.Specials.Pre e) {
/* 28 */     EntityLivingBase el = e.entityLiving;
/* 29 */     if (el instanceof EntityPlayer && 
/* 30 */       ((EntityPlayer)el).field_71071_by instanceof InventoryPlayerTFC) {
/* 31 */       ItemStack[] equipables = ((InventoryPlayerTFC)((EntityPlayer)el).field_71071_by).extraEquipInventory;
/* 32 */       for (ItemStack i : equipables) {
/* 33 */         if (i != null && i.func_77973_b() instanceof com.bioxx.tfc.Items.ItemQuiver) {
/* 34 */           RENDER_QUIVER.render(e.entityLiving, i);
/*    */         }
/* 36 */         else if (i != null) {
/* 37 */           RENDER_LARGE.render(el, i);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent e) {}
/*    */   
/*    */   @SubscribeEvent
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void onPlayerTick(TickEvent.PlayerTickEvent e) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Client\PlayerRenderHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */