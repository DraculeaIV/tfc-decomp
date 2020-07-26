/*    */ package com.bioxx.tfc.Items;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFCTabs;
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.TerraFirmaCraft;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemCustomNameTag
/*    */   extends ItemTerra
/*    */ {
/*    */   public ItemCustomNameTag() {
/* 20 */     func_77656_e(0);
/* 21 */     func_77627_a(true);
/* 22 */     func_77655_b("Nametag");
/* 23 */     func_77637_a(TFCTabs.TFC_TOOLS);
/* 24 */     setFolder("tools/");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_77651_p() {
/* 30 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IIcon getIcon(ItemStack stack, int pass) {
/* 36 */     return Items.field_151057_cb.getIcon(stack, pass);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IIcon func_77617_a(int damage) {
/* 42 */     return Items.field_151057_cb.func_77617_a(damage);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack stack, World world, EntityPlayer player) {
/* 49 */     if (stack.field_77990_d == null)
/*    */     {
/* 51 */       stack.field_77990_d = new NBTTagCompound();
/*    */     }
/* 53 */     if (stack.field_77990_d != null && !stack.field_77990_d.func_74764_b("ItemName"))
/*    */     {
/* 55 */       player.openGui(TerraFirmaCraft.instance, 48, player.field_70170_p, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*    */     }
/*    */     
/* 58 */     return stack;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister registerer) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 70 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_77653_i(ItemStack is) {
/* 76 */     if (is.func_77942_o() && is.field_77990_d.func_74764_b("ItemName"))
/* 77 */       return is.field_77990_d.func_74779_i("ItemName"); 
/* 78 */     return TFC_Core.translate("gui.Nametag");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemCustomNameTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */