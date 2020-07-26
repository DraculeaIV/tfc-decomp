/*    */ package com.bioxx.tfc.ASM.Transform;
/*    */ 
/*    */ import com.bioxx.tfc.ASM.ClassTransformer;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.objectweb.asm.tree.AbstractInsnNode;
/*    */ import org.objectweb.asm.tree.IntInsnNode;
/*    */ import org.objectweb.asm.tree.LdcInsnNode;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TF_EntityFallingBlock
/*    */   extends ClassTransformer
/*    */ {
/*    */   public TF_EntityFallingBlock() {
/* 26 */     List<ClassTransformer.InstrSet> nodes = new ArrayList<ClassTransformer.InstrSet>();
/* 27 */     nodes.add(new ClassTransformer.InstrSet(this, (AbstractInsnNode)new IntInsnNode(17, 2000), 13, ClassTransformer.InstrOpType.Replace));
/* 28 */     nodes.add(new ClassTransformer.InstrSet(this, (AbstractInsnNode)new LdcInsnNode(Float.valueOf(100.0F)), 18, ClassTransformer.InstrOpType.Replace));
/* 29 */     ClassTransformer.Patch patch = new ClassTransformer.Patch(this, nodes);
/* 30 */     this.mcpMethodNodes.put("<init> | (Lnet/minecraft/world/World;DDDLnet/minecraft/block/Block;I)V", patch);
/* 31 */     this.obfMethodNodes.put("<init> | (Lafn;DDDILahu;I)V", patch);
/*    */     
/* 33 */     nodes = new ArrayList<ClassTransformer.InstrSet>();
/* 34 */     nodes.add(new ClassTransformer.InstrSet(this, (AbstractInsnNode)new IntInsnNode(17, 2000), 13, ClassTransformer.InstrOpType.Replace));
/* 35 */     nodes.add(new ClassTransformer.InstrSet(this, (AbstractInsnNode)new LdcInsnNode(Float.valueOf(100.0F)), 18, ClassTransformer.InstrOpType.Replace));
/* 36 */     patch = new ClassTransformer.Patch(this, nodes);
/* 37 */     this.mcpMethodNodes.put("<init> | (Lnet/minecraft/world/World;)V", patch);
/* 38 */     this.obfMethodNodes.put("<init> | (Lafn;)V", patch);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\ASM\Transform\TF_EntityFallingBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */