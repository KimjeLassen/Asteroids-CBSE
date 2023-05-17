import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;

module CommonBullet {
    requires Common;

    exports dk.sdu.mmmi.cbse.common.bullet;

    uses BulletSPI;
}