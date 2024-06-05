
const stats = [
    { id: 1, titulo: 'Weekly', valor: '714k', icono: 'https://minimal-kit-react.vercel.app/assets/icons/glass/ic_glass_bag.png' },
    { id: 2, titulo: 'New Users', valor: '1.35m', icono: 'https://minimal-kit-react.vercel.app/assets/icons/glass/ic_glass_users.png' },
    { id: 3, titulo: 'Item Orders', valor: '1.72m', icono: 'https://minimal-kit-react.vercel.app/assets/icons/glass/ic_glass_buy.png' },
    { id: 4, titulo: 'Bug Reports', valor: '234', icono: 'https://minimal-kit-react.vercel.app/assets/icons/glass/ic_glass_message.png' }
]

export default function InfoCardsGroup() {
    return (
        <div className="flex flex-row justify-around flex-wrap py-5 px-6 text-white">
            {/*Para mis tarjetas etiquetas */}
            {stats.map((stat) => (
                <div key={stat.id} className="flex flex-row justify-start backdrop-blur-3xl border border-white rounded-2xl w-48 h-24 my-2 mx-2">
                    <div className='px-2 py-2'>
                        <img src={stat.icono} alt="icono-card" />
                    </div>
                    <div className='flex flex-col justify-center'>
                        <h1 className='text-2xl'>{stat.valor}</h1>
                        <h1>{stat.titulo}</h1>
                    </div>
                </div>
            ))}

        </div>
    )
}