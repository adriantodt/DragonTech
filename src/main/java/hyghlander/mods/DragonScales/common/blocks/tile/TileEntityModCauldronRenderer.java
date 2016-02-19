package hyghlander.mods.DragonScales.common.blocks.tile;

import hyghlander.mods.DragonScales.common.blocks.BlockModCauldron;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;

public class TileEntityModCauldronRenderer extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float size) {
		RenderBlocks renderer = RenderBlocks.getInstance();
		Block block =  te.blockType;
		renderer.renderStandardBlock(block, (int)x, (int)y, (int)z);
        Tessellator tessellator = Tessellator.instance;
        tessellator.setBrightness(block.getMixedBrightnessForBlock(renderer.blockAccess, (int)x, (int)y, (int)z));
        int l = block.colorMultiplier(renderer.blockAccess, (int)x, (int)y, (int)z);
        float f = (float)(l >> 16 & 255) / 255.0F;
        float f1 = (float)(l >> 8 & 255) / 255.0F;
        float f2 = (float)(l & 255) / 255.0F;
        float f4;

        if (EntityRenderer.anaglyphEnable)
        {
            float f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
            f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
            float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
            f = f3;
            f1 = f4;
            f2 = f5;
        }

        tessellator.setColorOpaque_F(f, f1, f2);
        IIcon iicon1 = block.getBlockTextureFromSide(2);
        f4 = 0.125F;
        renderer.renderFaceXPos(block, (double)((float)x - 1.0F + f4), (double)y, (double)z, iicon1);
        renderer.renderFaceXNeg(block, (double)((float)x + 1.0F - f4), (double)y, (double)z, iicon1);
        renderer.renderFaceZPos(block, (double)x, (double)y, (double)((float)z - 1.0F + f4), iicon1);
        renderer.renderFaceZNeg(block, (double)x, (double)y, (double)((float)z + 1.0F - f4), iicon1);
        IIcon iicon2 = BlockModCauldron.getCauldronIcon("inner");
        renderer.renderFaceYPos(block, (double)x, (double)((float)y - 1.0F + 0.25F), (double)z, iicon2);
        renderer.renderFaceYNeg(block, (double)x, (double)((float)y + 1.0F - 0.75F), (double)z, iicon2);
        int i1 = renderer.blockAccess.getBlockMetadata((int)x, (int)y, (int)z);

        if (i1 > 0)
        {
            IIcon iicon = BlockLiquid.getLiquidIcon("lava_still");
            renderer.renderFaceYPos(block, (double)x, (double)((float)y - 1.0F + BlockModCauldron.getRenderLiquidLevel(i1)), (double)z, iicon);
        }
	}

}
