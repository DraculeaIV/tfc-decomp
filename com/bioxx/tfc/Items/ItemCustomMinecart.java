/*    */ package com.bioxx.tfc.Items;
/*    */ 
/*    */ import com.bioxx.tfc.Entities.EntityCustomMinecart;
/*    */ import com.bioxx.tfc.api.Enums.EnumSize;
/*    */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.BlockRailBase;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemCustomMinecart
/*    */   extends ItemTerra
/*    */ {
/*    */   public int minecartType;
/*    */   
/*    */   public ItemCustomMinecart(int par2) {
/* 24 */     this.field_77777_bU = 1;
/* 25 */     this.minecartType = par2;
/* 26 */     func_77637_a(CreativeTabs.field_78029_e);
/* 27 */     setWeight(EnumWeight.HEAVY);
/* 28 */     setSize(EnumSize.HUGE);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister registerer) {
/* 34 */     this.field_77791_bV = registerer.func_94245_a("minecart_chest");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_77648_a(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 40 */     if (BlockRailBase.func_150051_a(world.func_147439_a(x, y, z))) {
/*    */       
/* 42 */       if (!world.field_72995_K)
/*    */       {
/* 44 */         world.func_72838_d((Entity)new EntityCustomMinecart(world, (x + 0.5F), (y + 0.5F), (z + 0.5F)));
/*    */       }
/*    */       
/* 47 */       itemstack.field_77994_a--;
/* 48 */       return true;
/*    */     } 
/*    */ 
/*    */     
/* 52 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_150895_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> par3List) {
/* 59 */     par3List.add(new ItemStack(par1, 1, 0));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canStack() {
/* 65 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemCustomMinecart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */