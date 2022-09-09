package ru.starfactory.pixel.ecu_connection.domain.connection.serial

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.starfactory.pixel.ecu_connection.domain.connection.EcuPrimaryState
import ru.starfactory.pixel.ecu_connection.domain.connection.EcuSourceConnectionInteractor

internal interface EcuSerialSourceConnectionInteractor : EcuSourceConnectionInteractor

@Suppress("MagicNumber")
internal class EcuSerialSourceConnectionInteractorImpl : EcuSerialSourceConnectionInteractor {
    override fun observePrimaryState(): Flow<EcuPrimaryState> {
        return flow {

            while (true) {
                for (it in 0..99) {
                    emit(EcuPrimaryState(it, it.toFloat()))
                    delay(100)
                }
                for (it in 99 downTo 0) {
                    emit(EcuPrimaryState(it, it.toFloat()))
                    delay(100)
                }
            }
        }
    }
}
